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
		//�ļ��ϴ�
		String path = this.getServletContext().getRealPath("/images");		
		//��ô����ļ�����Ŀ����������
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//���û�����
		factory.setRepository(new File(path));
		//���û�������С
		factory.setSizeThreshold(1024*1024);		
		//��ȡ��ˮƽ�ļ������API������
		ServletFileUpload upload = new ServletFileUpload(factory);		
		try {
			List<FileItem> list = (List<FileItem>)upload.parseRequest(request);			
			for (FileItem item:list){				
				//��ȡ������������
				String name = item.getFieldName();
				//��ñ�������
				//�жϵ�ǰ��item�Ƿ�Ϊ��ͨ���ı�
				if(item.isFormField()) {
					//��ȡ�û�����������û���
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
					//�Ǽ����ͣ�����˵�����Ƶ�ͼƬ����Ӱ����Ƶ��Ƶ��
					//������		
					//1.��ȡ�ļ�·��					
					String filepath = item.getName();					
					//���������һ����б��
					int start = filepath.lastIndexOf("\\");
					//��ȡ�ļ���
					String filename = filepath.substring(start+1);	
					product.setImgName(filename);
					request.setAttribute(name, filename);				
					//���ļ�д������
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
		//д�����ݿ�
		ProductDao productDao = new ProductDao();
		productDao.insertProduct(product);
		response.sendRedirect("manger");
		
		
		
	}
	
	//�ϴ������ݿ�

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
