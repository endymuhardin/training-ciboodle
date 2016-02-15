package com.brainmatics.training.spring.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AbsensiDao {
	@Autowired private KoneksiDatabase koneksi;
	
	public void simpan(){
		koneksi.connect();
		System.out.println("Menyimpan data");
		koneksi.disconnect();
	}
	
	public void hapus(){
		koneksi.connect();
		System.out.println("Menghapus data");
		koneksi.disconnect();
	}
}
