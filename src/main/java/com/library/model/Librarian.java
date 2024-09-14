package com.library.model;

import java.util.Date;

public class Librarian {
    private int librarian_id;
    private String first_name;
    private String last_name;
    private int account_id;
    private Date created_at;
    private Date updated_at;
    private String email;
    private String phone;

    public Librarian(int librarian_id, String first_name, String last_name, int account_id, Date created_at, Date updated_at, String email, String phone) {
        this.librarian_id = librarian_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.account_id = account_id;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.email = email;
        this.phone = phone;
    }

    public int getLibrarianId() { return librarian_id; }
    public void setLibrarianId(int librarian_id) { this.librarian_id = librarian_id; }

    public String getFirstName() { return first_name; }
    public void setFirstName(String first_name) { this.first_name = first_name; }

    public String getLastName() { return last_name; }
    public void setLastName(String last_name) { this.last_name = last_name; }

    public int getAccountId() { return account_id; }
    public void setAccountId(int account_id) { this.account_id = account_id; }

    public Date getCreatedAt() { return created_at; }
    public void setCreatedAt(Date created_at) { this.created_at = created_at; }

    public Date getUpdatedAt() { return updated_at; }
    public void setUpdatedAt(Date updated_at) { this.updated_at = updated_at; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    @Override
    public String toString() {
        return "Librarian{" +
                "librarian_id=" + librarian_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", account_id=" + account_id +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        // Equality logic here
        return super.equals(obj);
    }
}
