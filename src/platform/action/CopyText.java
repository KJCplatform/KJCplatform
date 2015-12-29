package platform.action;


import java.io.*;

public class CopyText {
	public static void copytext(String yuan1,String mudi1) throws Exception{
		/*System.out.println(yuan1);
		System.out.println(mudi1);*/
		String yuan=yuan1;
		String mudi=mudi1;
		/*System.out.println(yuan);*/
		(new File(mudi)).mkdirs();
		File[] files =(new File(yuan)).listFiles();
		for(File file:files){
			if(file.isDirectory()){
				String yuanDir=yuan+"\\"+file.getName();
				String mudiDir=mudi+"\\"+file.getName();
				copyDir(yuanDir,mudiDir);
			}else{
				copyFile(file,new File(mudi+"\\"+file.getName()));
			}
		}
	}
	
	/*public static void copytext1(String[] args) throws Exception{
		String yuan="E:\\kjcdata";
		String mudi="D:\\kjcdata";
		(new File(mudi)).mkdirs();
		File[] files =(new File(yuan)).listFiles();
		for(File file:files){
			if(file.isDirectory()){
				String yuanDir=yuan+"\\"+file.getName();
				String mudiDir=mudi+"\\"+file.getName();
				copyDir(yuanDir,mudiDir);
			}else{
				copyFile(file,new File(mudi+"\\"+file.getName()));
			}
		}
	}*/
	
	
	public static void copyDir(String yuanDir,String mudiDir)throws Exception{
		(new File(mudiDir)).mkdirs();
		File[] files =(new File(yuanDir)).listFiles();
		for(File file:files){
			if(file.isFile()){
				File yuanFile=file;
				File mudiFile=new File(new File(mudiDir).getAbsolutePath()+"\\"+file.getName());
				copyFile(yuanFile,mudiFile);
			}else{
				String yuanJia=yuanDir+"\\"+file.getName();
				String mudiJia=mudiDir+"\\"+file.getName();
				copyDir(yuanJia,mudiJia);
			}
		}
	}
	
	public static void copyFile(File yuanFile,File mudiFile)throws Exception{
		BufferedInputStream buis=new BufferedInputStream(new FileInputStream(yuanFile.getAbsoluteFile()));
		BufferedOutputStream buos=new BufferedOutputStream(new FileOutputStream(mudiFile.getAbsoluteFile()));
		byte[] buf=new byte[1024];
		int len;
		while((len=buis.read(buf))!=-1){
			buos.write(buf,0,len);
			buos.flush();
			
		}
		buis.close();
		buos.close();
		
	} 
	/*private static final int BUFFER_SIZE=1024;

	public static void copytext(String[] args) throws IOException{
		FileReader fr=null;
		FileWriter fw=null;
		try{
			fr=new FileReader("C:/IO流_2.txt");
			fw=new FileWriter("D:/copytext_1.txt");
			char[] buf=new char[BUFFER_SIZE];
			int len=0;
			while((len=fr.read(buf))!=-1){
				fw.write(buf,0,len);
			}
		}catch(Exception e){
			throw new RuntimeException("读写失败");
		}finally{
			if(fw!=null)
				try{
					fw.close();
				}catch(IOException e){
					e.printStackTrace();
				}
		}
		FileReader fr=new FileReader("C:/IO流_2.txt");
		FileWriter fw=new FileWriter("D:/copytext_1.txt");
		int ch=0;
		while((ch=fr.read())!=-1){
			fw.write(ch);
		}
		fw.close();
		fr.close();

	
	
}
*/
}