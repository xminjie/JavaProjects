package action;

import factory.ObjectFactory;
import service.serviceProxy.AdminUserServiceProxyImp;

import javax.swing.*;
import java.awt.*;

public class AdminUserLoginFrame {


    private JFrame jf;
    private JLabel JLAccount, JLPassword;
    private JTextField JTAccount;
    private JPasswordField JP;
    private JButton JBEnter, JBClear;

    AdminUserLoginFrame() {
        jf = new JFrame("管理员登录");
        JLAccount = new JLabel("账户 ");
        JLPassword = new JLabel("密码 ");
        JTAccount = new JTextField(10);

        JP = new JPasswordField(10);

        JBClear = new JButton("重置");
        JBEnter = new JButton("确定");

    }

    private void actionHandle() {
        JBClear.addActionListener(e -> {

            JTAccount.setText(null);
            JP.setText(null);

        });

        JBEnter.addActionListener(e -> {
//                验证信息输入格式
//                调用登录方法
            AdminUserServiceProxyImp adminUserServiceProxyImp = (AdminUserServiceProxyImp) ObjectFactory.getObject("AdminUserServiceProxyImp");
            String s1 = JTAccount.getText();
            String s2 = new String(JP.getPassword());
            if ((Who.adminUser = adminUserServiceProxyImp.login(s1, s2)) != null) {
                JOptionPane.showMessageDialog(jf, "登陆成功");
                JOptionPane.getFrameForComponent(jf).dispose();
                new AdminFlightFrame().show("航班管理:" + Who.adminUser.getAccount());
            } else {
                JOptionPane.showMessageDialog(jf, "用户名密码不匹配");
            }
//

        });
    }

    private void init() {
        jf.add(JLAccount);
        jf.add(JTAccount);
        jf.add(JLPassword);
        jf.add(JP);
        jf.add(JBClear);
        jf.add(JBEnter);

    }

    void show() {
        init();
        jf.setResizable(false);
        actionHandle();
        jf.setLayout(new FlowLayout());
        jf.setBounds(300, 300, 407, 178);
        jf.setVisible(true);
//        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new AdminUserLoginFrame().show();
    }

}
