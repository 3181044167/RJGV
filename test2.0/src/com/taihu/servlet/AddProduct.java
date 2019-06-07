package com.taihu.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.taihu.dao.ProductDao;
import com.taihu.model.Product;

/**
 * Servlet implementation class AddProduct
 */
@WebServlet("/addProduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//request.setCharacterEncoding("utf-8");
		Product product = new Product();
		//文件上传
		String path = this.getServletContext().getRealPath("/images");		
		//获得磁盘文件的条目工厂（对象）
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//设置缓冲区
		factory.setRepository(new File(path));
		//设置缓冲区大小
		factory.setSizeThreshold(1024*1024);		
		//获取高水平文件处理的API（对象）
		ServletFileUpload upload = new ServletFileUpload(factory);		
		try {
			List<FileItem> list = (List<FileItem>)upload.parseRequest(request);			
			for (FileItem item:list){				
				//获取表单的属性名称
				String name = item.getFieldName();
				//获得表单的类型
				//判断当前的item是否为普通的文本
				if(item.isFormField()) {
					//获取用户具体输入的用户名
					String value = item.getString();
					System.out.println(name+"---"+value);
					if(name.equals("pname")) {
						value  = new String(value.getBytes("iso-8859-1"),"utf-8");
						product.setPname(value);
					}else if(name.equals("detail")) {
						value = new String(value.getBytes("iso-8859-1"),"utf-8");
						product.setDetail(value);
					}else if(name.equals("price")) {
						double price = Double.parseDouble(value);
						product.setPrice(price);
					}
						
					request.setAttribute(name, value);					
				}else {
					//非简单类型，比如说二进制的图片，电影（音频视频）
					//分三步		
					//1.获取文件路径					
					String filepath = item.getName();					
					//索引到最后一个反斜杠
					int start = filepath.lastIndexOf("\\");
					//获取文件名
					String filename = filepath.substring(start+1);	
					product.setImgName(filename);
					request.setAttribute(name, filename);				
					//将文件写到磁盘
					OutputStream out = new FileOutputStream(new File(path,filename));
					InputStream in = item.getInputStream();
					byte [] buff = new byte[1024];
					int lenght = 0;
					while( (lenght = in.read(buff) ) != -1) {
						out.write(buff, 0, lenght);						
					}
					in.close();
					out.close();
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//写到数据库
		ProductDao productDao = new ProductDao();
		productDao.insertProduct(product);
		response.sendRedirect("manger");
		
		
		
	}
	
	//上传到数据库

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
