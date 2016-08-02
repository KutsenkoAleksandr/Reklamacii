package ua.kay.reclamacii.models;

import org.apache.tomcat.util.codec.binary.Base64;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "account", schema = "", catalog = "reclamacii")
public class Account implements Serializable {

    private static final long serialVersionUID = -4756418699652703026L;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id_account", nullable = false, insertable = true, updatable = true)
    private Long idAccount;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "password")
    private String password;

    public Long getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Long idAccount) {
        this.idAccount = idAccount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        byte[] encodedPassword = Base64.decodeBase64(password);
        return new String(encodedPassword);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAccount, name, password);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Account other = (Account) obj;
        return Objects.equals(this.idAccount, other.idAccount)
                && Objects.equals(this.name, other.name)
                && Objects.equals(this.password, other.password);
    }
}
