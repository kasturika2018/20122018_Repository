package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.ContactFormBean;
import com.training.bean.LoginBean;
import com.training.dao.ContactFormDAO;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcelRead;

public class ContactFormwithDBDataProvider {
	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<ContactFormBean> list = new ContactFormDAO().getContactForms(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(ContactFormBean temp : list){
			Object[]  obj = new Object[4]; 
			obj[0] = temp.getName(); 
			obj[1] = temp.getEmail();
			obj[2] = temp.getSubject();
			obj[3] = temp.getMessage();
			
			result[count ++] = obj; 
		}
				
		return result;
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		//String fileName = "C:\\Users\\KasturikaDasgupta\\Desktop\\Testing1.xlsx";
		String fileName = "./resources/Testing1.xlsx";
		List<List<Object>> retVal = ApachePOIExcelRead.getExcelContent(fileName);
		System.out.println("size " + retVal.size());
		
		Object[][] result = new Object[retVal.size()][retVal.size()]; 
		int count = 0; 

		for(List<Object> temp : retVal){
			if(temp!=null){
			Object[]  obj = new Object[4]; 
			System.out.println(temp.get(0));
			System.out.println(temp.get(1));
			System.out.println(temp.get(2));
			System.out.println(temp.get(3));

			obj[0] = temp.get(0); 
			obj[1] = temp.get(1); 
			obj[2] = temp.get(2); 
			obj[3] = temp.get(3);
			
			result[count ++] = obj; 
			}
		}
		
		return result; 
	}
}
