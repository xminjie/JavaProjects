package action;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlyFrame {
    private JFrame jf;
    private JButton JBUserLogin, JBUserRegister, JBSelect, JBAdminUserLogin;

    FlyFrame() {
        JBUserLogin = new JButton("用户登录");
        JBUserRegister = new JButton("用户注册");
        JBSelect = new JButton("访客查询");
        JBAdminUserLogin = new JButton("管理员登录");
    }

    private void init() {
        jf = new JFrame("欢迎使用飞机票订票系统");
        jf.add(JBUserLogin);
        jf.add(JBUserRegister);
        jf.add(JBSelect);
        jf.add(JBAdminUserLogin);
    }

    private void actionHandle() {
        JBUserLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UserLoginFrame().show();
            }
        });

        JBUserRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UserRegisterFrame().show();
            }
        });

        JBSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new OnlySelectFrame().show("访客查询");
            }
        });
        JBAdminUserLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminUserLoginFrame().show();
            }
        });
    }


    void show() {
        init();
        actionHandle();
        jf.setLayout(new FlowLayout());
        jf.setBounds(358, 20, 550, 193);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new FlyFrame().show();
    }
}
