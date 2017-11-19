package com.zdp.upload;

public class FtpUploadTest {

//    @Test
//    public void testFtpClient() throws Exception{
//
//        //创建一个ftpClient客户端对象
//        FTPClient ftpClient=new FTPClient();
//        //发送链接
//        ftpClient.connect("10.31.161.44",21);
//        //登录
//        ftpClient.login("ftpuser","root");
//        //读取本地文件
//        FileInputStream fs=new FileInputStream(new File("f:\\a.png"));
//        //配置上传参数
//        ftpClient.changeWorkingDirectory("/home/ftpuser/www/images");
//        //设置文件类型为二进制
//        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
//        //执行上传方法
//        ftpClient.storeFile("hello.jpg",fs);
//        //释放资源
//        fs.close();
//        ftpClient.logout();
//
//    }
//    @Test
//    public void ftpUtils() throws Exception{
//        FileInputStream fileInputStream=new FileInputStream(new File("f:\\a.png"));
//        FtpUtils.uploadFile("10.31.161.44",21,"ftpuser","root",
//                "/home/ftpuser/www/images","/2017/11/17","hello2.jpg",fileInputStream);
//        fileInputStream.close();
//    }
}
