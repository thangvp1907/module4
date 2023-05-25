package com.codegym.service;

import com.codegym.model.Mail;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class serviceImp implements iService {
    private static List<Mail> mailList = new ArrayList<>();
    private static List<String> languagesList = new ArrayList<>();
    private static List<Integer> pageSizeList = new ArrayList<>();

    static {
        languagesList.add("English");
        languagesList.add("Vietnamese");
        languagesList.add("Japanese");
        languagesList.add("Chinese");

        pageSizeList.add(5);
        pageSizeList.add(10);
        pageSizeList.add(15);
        pageSizeList.add(25);
        pageSizeList.add(50);
        pageSizeList.add(100);

        mailList.add(new Mail(1, "English", 25, true, "Thắng"));
        mailList.add(new Mail(2, "Vietnamese", 5, false, "Mạnh"));
        mailList.add(new Mail(3, "Japanese", 100, true, "Thương"));
    }

    @Override
    public List<Mail> findAll() {
        return mailList;
    }

    @Override
    public Mail findById(int id) {
        for (Mail emailBox : mailList) {
            if (emailBox.getId() == id) {
                return emailBox;
            }
        }
        return null;
    }

    @Override
    public List<String> findByLanguagesList() {
        return languagesList;
    }

    @Override
    public List<Integer> findByPageSize() {
        return pageSizeList;
    }

    @Override
    public void save(Mail mail) {
        for (Mail email : mailList) {
            if(email.getId() == mail.getId()){
                mailList.remove(email);
                mailList.add(mail);
                break;
            }
        }
    }
}
