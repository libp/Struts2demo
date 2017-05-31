package com.peng.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

/** 
 * @author Peng
 * @Email 924701358@qq.com
 * @date 2017年5月31日 下午3:02:15 
 * @version 1.0 
 * @return  
 */

public class UploadAction extends ActionSupport{
	private String title;  
    private String myFileFileName;  
    private File myFile;  
    private String myFileContentType;
    
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMyFileFileName() {
		return myFileFileName;
	}

	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}

	public File getMyFile() {
		return myFile;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}

	public String getMyFileContentType() {
		return myFileContentType;
	}

	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}

	public String upload() throws IOException{
		InputStream is=null;  
        OutputStream os=null;
        File newfile = new File("/opt/test/");
        if (!newfile.exists()) {
            newfile.mkdirs();
        }  
        try {  
            is = new BufferedInputStream(new FileInputStream(myFile));  
            os = new BufferedOutputStream(new FileOutputStream("/opt/test/"+myFileFileName));  
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");//设置日期格式
            System.out.println("temp file save time:"+df.format(new Date()));
            byte[] buffer = new byte[1024];  
            int len=0;  
            while((len=is.read(buffer))>0){  
                os.write(buffer,0,len);  
            }
            System.out.println("new file having save time:"+df.format(new Date()));
        }catch(Exception e){
        	
        }finally{  
            if(is !=null){is.close();}  
            if(os!=null){os.close();}
            
        }  
		return SUCCESS;
	}
}

