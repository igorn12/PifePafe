package pifpaf;

import java.util.Objects;

public class Carta implements Comparable<Carta>{
    private final String face;
    private final String naipe;
    private final String peso;
    private int cont=0;

    public Carta(String face, String naipe, String peso, int cont) {
        this.face = face;
        this.naipe = naipe;
        this.peso = peso;
        this.cont = cont;
    }

    public String getFace() {
        return face;
    }

    public String getNaipe() {
        return naipe;
    }

    public String getPeso() {
        return peso;
    }

    public int getCont() {
        return cont;
    }

    @Override
    public String toString() {
        return face+" De "+naipe;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.face);
        hash = 67 * hash + Objects.hashCode(this.naipe);
        hash = 67 * hash + Objects.hashCode(this.peso);
        hash = 67 * hash + this.cont;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carta other = (Carta) obj;
        if (this.cont != other.cont) {
            return false;
        }
        if (!Objects.equals(this.face, other.face)) {
            return false;
        }
        if (!Objects.equals(this.naipe, other.naipe)) {
            return false;
        }
        return Objects.equals(this.peso, other.peso);
    }

    @Override
    public int compareTo(Carta c) {
        if(this.peso.equals(c.peso))
            if(this.face.equals(c.face))
                return this.naipe.compareTo(naipe);
        return this.peso.compareTo(c.peso);
    }
    
}
