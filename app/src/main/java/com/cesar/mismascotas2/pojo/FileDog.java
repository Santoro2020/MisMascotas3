package com.cesar.mismascotas2.pojo;

import java.util.ArrayList;

public class FileDog {

        private int fotofile;
        private String nombre;
        private ArrayList<Miperro> fotosfile;

        public int getFotoFile() {
            return fotofile;
        }

        public void setFotoFile(int fotofile) {
            this.fotofile = fotofile;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public ArrayList<Miperro> getFotosfile() {
            return fotosfile;
        }

        public void setFotosfile(ArrayList<Miperro> fotosfile) {
            this.fotosfile = fotosfile;
        }
    }


