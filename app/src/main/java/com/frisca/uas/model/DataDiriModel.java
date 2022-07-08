package com.frisca.uas.model;

public class DataDiriModel {

    String nama;
    String nim;
    String alamat;
    String nohp;
    String jurusan;
    String kelas;
    String key;

    public DataDiriModel() {

    }

    public DataDiriModel(String nama, String nim, String alamat, String nohp, String jurusan, String kelas) {
        this.nama = nama;
        this.nim = nim;
        this.alamat = alamat;
        this.nohp = nohp;
        this.jurusan = jurusan;
        this.kelas = kelas;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }
}
