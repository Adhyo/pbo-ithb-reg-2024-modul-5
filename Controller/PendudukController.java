package Controller;

import Model.Penduduk;
import View.*;

import javax.swing.*;
import java.util.Date;

public class PendudukController {
    private Penduduk model;
    private FormInputView inputView;
    private HasilKTPView hasilView;

    public PendudukController() {
        model = new Penduduk();
        inputView = new FormInputView(this);
    }

    public void savePenduduk(String nik, String nama, String tempatLahir, Date tanggalLahir,
                            String jenisKelamin, String golDarah, String alamat, String rtRw,
                            String kelDesa, String kecamatan, String agama, String statusPerkawinan,
                            String pekerjaan, String kewarganegaraan, String foto, String tandaTangan,
                            String berlakuHingga, String kotaPembuatan, Date tanggalPembuatan) {
        
        if (validateData(nik, nama, tempatLahir, tanggalLahir, jenisKelamin, golDarah, 
                        alamat, rtRw, kelDesa, kecamatan, agama, statusPerkawinan, 
                        pekerjaan, kewarganegaraan, foto, tandaTangan, berlakuHingga, 
                        kotaPembuatan, tanggalPembuatan)) {
            
            model.setNik(nik);
            model.setNama(nama);
            model.setTempatLahir(tempatLahir);
            model.setTanggalLahir(tanggalLahir);
            model.setJenisKelamin(jenisKelamin);
            model.setGolDarah(golDarah);
            model.setAlamat(alamat);
            model.setRtRw(rtRw);
            model.setKelDesa(kelDesa);
            model.setKecamatan(kecamatan);
            model.setAgama(agama);
            model.setStatusPerkawinan(statusPerkawinan);
            model.setPekerjaan(pekerjaan);
            model.setKewarganegaraan(kewarganegaraan);
            model.setFoto(foto);
            model.setTandaTangan(tandaTangan);
            model.setBerlakuHingga(berlakuHingga);
            model.setKotaPembuatan(kotaPembuatan);
            model.setTanggalPembuatan(tanggalPembuatan);

            JOptionPane.showMessageDialog(inputView, "Data berhasil disimpan!");
            showKTPView();
        }
    }

    private boolean validateData(String nik, String nama, String tempatLahir, Date tanggalLahir,
                               String jenisKelamin, String golDarah, String alamat, String rtRw,
                               String kelDesa, String kecamatan, String agama, String statusPerkawinan,
                               String pekerjaan, String kewarganegaraan, String foto, String tandaTangan,
                               String berlakuHingga, String kotaPembuatan, Date tanggalPembuatan) {
        
        if (nik.isEmpty() || nama.isEmpty() || tempatLahir.isEmpty() || tanggalLahir == null ||
            jenisKelamin == null || golDarah == null || alamat.isEmpty() || rtRw.isEmpty() ||
            kelDesa.isEmpty() || kecamatan.isEmpty() || agama == null || statusPerkawinan == null ||
            pekerjaan.isEmpty() || kewarganegaraan == null || foto.isEmpty() || tandaTangan.isEmpty() ||
            berlakuHingga.isEmpty() || kotaPembuatan.isEmpty() || tanggalPembuatan == null) {
            
            JOptionPane.showMessageDialog(inputView, "Semua field harus diisi!", 
                                        "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private void showKTPView() {
        hasilView = new HasilKTPView(model);
        hasilView.setVisible(true);
        inputView.dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PendudukController();
        });
    }
}