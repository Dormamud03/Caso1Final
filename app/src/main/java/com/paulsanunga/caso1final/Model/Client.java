package com.paulsanunga.caso1final.Model;

public class Client {

    private String cedulaClient;
    private String nombresClient;
    private String emailClient;
    private String celularClient;
    private String direccionClient;
    private String passwordClient;

    public Client() {
    }

    public Client(String cedulaClient, String nombresClient, String emailClient, String celularClient, String direccionClient, String passwordClient) {
        this.cedulaClient = cedulaClient;
        this.nombresClient = nombresClient;
        this.emailClient = emailClient;
        this.celularClient = celularClient;
        this.direccionClient = direccionClient;
        this.passwordClient = passwordClient;
    }

    public String getCedulaClient() {
        return cedulaClient;
    }

    public void setCedulaClient(String cedulaClient) {
        this.cedulaClient = cedulaClient;
    }

    public String getNombresClient() {
        return nombresClient;
    }

    public void setNombresClient(String nombresClient) {
        this.nombresClient = nombresClient;
    }

    public String getEmailClient() {
        return emailClient;
    }

    public void setEmailClient(String emailClient) {
        this.emailClient = emailClient;
    }

    public String getCelularClient() {
        return celularClient;
    }

    public void setCelularClient(String celularClient) {
        this.celularClient = celularClient;
    }

    public String getDireccionClient() {
        return direccionClient;
    }

    public void setDireccionClient(String direccionClient) {
        this.direccionClient = direccionClient;
    }

    public String getPasswordClient() {
        return passwordClient;
    }

    public void setPasswordClient(String passwordClien) {
        this.passwordClient = passwordClien;
    }
}
