package com.example.signupactivity;

public class Upload {
    private String hostelname;
    private String contactno;
    private String address;
    private String imgurl;

    public Upload(){

    }

    public Upload(String hname, String no, String addr, String img){
        if(hname.trim().equals("")){
            hname = "No Hostel Name provided!";
        }
        hostelname = hname;
        contactno = no;
        address = addr;
        imgurl = img;

    }

    public String getHostelname(){
        return hostelname;
    }
    public void setHostelname(String hname){
        hostelname = hname;
    }

    public String getContactno(){
        return contactno;
    }

    public void setContactno(String no){
        contactno = no;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String addr){
        address = addr;
    }

    public String getImgurl(){
        return imgurl;
    }

    public void setImgurl(String img){
        imgurl = img;
    }
}
