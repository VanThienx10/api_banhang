package com.example.api_banhang.sevices;

import com.example.api_banhang.model.LoaiSanPham;
import com.example.api_banhang.repostory.LoaiSanPhamRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoaiSanPhamServices {
    @Autowired
    private LoaiSanPhamRepostory loaiSanPhamRepostory;

    public String ThemLoaiSanPham(LoaiSanPham loaiSanPham){
        loaiSanPhamRepostory.save(loaiSanPham);
        return "Them thanh cong !";
    }

    public String SuaLoaiSanPHam(LoaiSanPham lspSua){
        Optional<LoaiSanPham> lsp = loaiSanPhamRepostory.findById(lspSua.getId());

        if (lsp.isEmpty()){
            return "Loai sp ko ton tai !";
        }else {
            LoaiSanPham lspCurrent = lsp.get();
            lspCurrent = lspSua;
            loaiSanPhamRepostory.save(lspCurrent);
            return "Sua thanh cong !";
        }
    }

    public String XoaLoaiSanPHam(int id_lsp){
        Optional<LoaiSanPham> lsp = loaiSanPhamRepostory.findById(id_lsp);
        if (lsp.isEmpty()){
            return "Loai sp ko ton tai !";
        }else {
            loaiSanPhamRepostory.deleteById(id_lsp);
            return "Xoa thanh cong !";
        }

    }

    public List<LoaiSanPham> GetAllLSP(){
        return loaiSanPhamRepostory.findAll();
    }
}
