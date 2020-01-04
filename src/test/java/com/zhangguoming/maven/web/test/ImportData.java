package com.zhangguoming.maven.web.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhanggm.common.utils.FileUtil;
import com.zhanggm.common.utils.StringUtil;
import com.zhangguoming.maven.web.dao.BookDao;
import com.zhangguoming.maven.web.entity.Book;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-beans.xml")
public class ImportData {
	
	@Autowired
	private BookDao bookDao;
	
	@Test
	public void importData() {
		List<String> list = FileUtil.readTextFileToList("C:\\Users\\Administrator\\Desktop\\data.txt");
		for(String recored:list) {
			try {
				String[] feildArr = recored.split("	");
				String phone = feildArr[2];
				String errorMessage = "";
				if(!StringUtil.isPhoneNum(phone)) {
					System.out.println(recored);
					errorMessage="手机号错误";
				}
				//
				String num = feildArr[4];
				if(!StringUtil.isNumber(num)) {
					System.out.println(recored);
					errorMessage+="欢迎度错误";
				}
				if(StringUtil.isNotNull(errorMessage)) {
					//保存到error_record表
					continue;
				}
				
				Book book = new Book();
				book.setId(Integer.parseInt(feildArr[0]));
				book.setName(feildArr[1]);
				
				book.setPhone(phone);
				book.setAuthor(feildArr[3]);
				
				book.setNum(Integer.parseInt(num));
				bookDao.insert(book);
//				System.out.println(book);
			}catch(Exception e) {
				System.out.println(recored);
				continue;
			}
			
		}
	}
}
