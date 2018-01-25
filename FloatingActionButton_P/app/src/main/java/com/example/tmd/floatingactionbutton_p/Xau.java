package com.example.tmd.floatingactionbutton_p;

public class Xau {
	String xau;
	String phu_am_dau;
	String nguyen_am;
	String phu_am_cuoi;
	int so_nguyen_am;
	int so_phu_am;
	
	public Xau (String xau){
		int i=0;
		xau=xau.trim();
		
		///xử lý khi xâu đi liền với dấu
		//loai bo cac ky tu dau xau la cac dau !"#$%&'()*+,-./:;<=>?@
		while (( (47>=xau.charAt(i))&&(xau.charAt(i))>=33 )||( (64>=xau.charAt(i))&&(xau.charAt(i))>=58 )){
			xau = xau.substring(0, i) + xau.substring(i + 1);
			if(xau.length()==0) break;
		}
		//loai bo cac ky tu cuoi xau la cac dau !"#$%&'()*+,-./:;<=>?@
		i=xau.length()-1;
		if(i>0){
			while (( (47>=xau.charAt(i))&&(xau.charAt(i))>=33 )||( (64>=xau.charAt(i))&&(xau.charAt(i))>=58 )){
				xau = xau.substring(0, i);
				i--;
				if(i==-1) break;
			}
		}
		
		this.xau=xau.toLowerCase();
	}
	
	public void setXau(String s1, String s2, String s3, int i1, int i2){
		phu_am_dau=s1; nguyen_am=s2; phu_am_cuoi=s3;
		so_nguyen_am=i1; so_phu_am=i2;
	}	
	
	public boolean binSearch(String x, String[] array){
		int first=0;
		int last=array.length;
		while (first<last){
			int mid=(first+last)/2;
			if (x.compareTo(array[mid])<0) last=mid;
			else {
				if (x.compareTo(array[mid])>0) first=mid+1;
				else {return true;}	
			}
		}
		return false;

	}
	
	public boolean isNguyenAm(String x){
		return binSearch(x, Rule.nguyenAm);
	}

	public boolean isPhuAm(String x) {
		if(binSearch(x,Rule.notPhuAmCuoi)!=true)
        	return (binSearch(x,Rule.phuAmCuoi));
        return true;
    }
	
	public boolean isPhuAmCuoi(String x){
		return (binSearch(x,Rule.phuAmCuoi));
	}
	
	public boolean isNguyenAmDacBiet(char x){
		int first=0;
		int last=Rule.nguyenAmDacBiet.length;
		while (first<last){
			int mid=(first+last)/2;
			if (x<Rule.nguyenAmDacBiet[mid]) last=mid;
			else {
				if (x>Rule.nguyenAmDacBiet[mid]) first=mid+1;
				else {return true;}	
			}
		}
        return false;
	}
		
	public boolean tachXau(){
		String tmpPAD ="",tmpNA="",tmpPAC="";
		int i;
		//lay phu am dau
		for(i=0;i<xau.length();i++){
			String tmp = String.valueOf(xau.charAt(i));
			if ((xau.charAt(0)=='g')&&(tmp.compareTo("i")==0)) {tmpPAD=tmpPAD.concat(tmp); so_phu_am++; }
			if (isPhuAm(tmp)==true) {tmpPAD=tmpPAD.concat(tmp); so_phu_am++; } 
			else break;
		}
		if (isPhuAm(tmpPAD)!=true) return false;
		//------------------------------------------------------------------------------
		//lay nguyen am
		for(i=so_phu_am;i<xau.length();i++){
			String tmp = String.valueOf(xau.charAt(i));
			if (isNguyenAm(tmp)==true) {tmpNA=tmpNA.concat(tmp); so_nguyen_am++; }
			else break;
		}
		if (isNguyenAm(tmpNA)!=true) return false;
		
		//------------------------------------------------------------------------------
		//lay phu am cuoi
		for(i=so_phu_am+so_nguyen_am;i<xau.length();i++){
			String tmp = String.valueOf(xau.charAt(i));
			if (isPhuAm(tmp)==true) {tmpPAC=tmpPAC.concat(tmp); so_phu_am++; }
			else break;
		}
		if (isPhuAmCuoi(tmpPAC)!=true) 	return false;
		//------------------------------------------------------------------------------
		if(so_phu_am+so_nguyen_am<xau.length()) return false;
		setXau(tmpPAD,tmpNA,tmpPAC,so_nguyen_am,so_phu_am);
		return true;
	}

	public String getXau() {
		return xau;
	}
}
