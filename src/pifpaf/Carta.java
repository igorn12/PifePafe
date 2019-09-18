package pifpaf;

import java.util.Objects;

public class Carta implements Comparable<Carta>{
    private final String face;
    private final String naipe;
    private final String peso;

    public Carta(String face, String naipe, String peso) {
        this.face = face;
        this.naipe = naipe;
        this.peso = peso;
    }

    @Override
    public String toString() {
        return face+" De "+naipe;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.face);
        hash = 89 * hash + Objects.hashCode(this.naipe);
        hash = 89 * hash + Objects.hashCode(this.peso);
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
        if (this.peso != other.peso) {
            return false;
        }
        if (!Objects.equals(this.face, other.face)) {
            return false;
        }
        if (!Objects.equals(this.naipe, other.naipe)) {
            return false;
        }
        return true;
    }

    
    
    @Override
    public int compareTo(Carta c) {
        if(this.peso.equals(c.peso))
            return this.naipe.compareTo(c.naipe);
        return this.peso.compareTo(c.peso);
    }
    
}
