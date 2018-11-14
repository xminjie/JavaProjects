package action;

import factory.ObjectFactory;
import service.serviceProxy.UserServiceProxyImp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserLoginFrame {


    private JFrame jf;
    private JLabel JLAccount, JLPassword;
    private JTextField JTAccount;
    private JPasswordField JP;
    private JButton JBEnter, JBClear;

    UserLoginFrame() {
        jf = new JFrame("用户登录");
        JLAccount = new JLabel("账户 ");
        JLPassword = new JLabel("密码 ");
        JTAccount = new JTextField(10);

        JP = new JPasswordField(10);

        JBClear = new JButton("重置");
        JBEnter = new JButton("确定");

    }

    public void actionHandle() {
        JBClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTAccount.setText(null);
                JP.setText(null);
            }
        });

        JBEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                验证信息输入格式
//                调用登录方法
                UserServiceProxyImp userServiceProxyImp = (UserServiceProxyImp) ObjectFactory.getObject("UserServiceProxyImp");
                String s1 = JTAccount.getText();
                String s2 = new String(JP.getPassword());
                if((Who.user = userServiceProxyImp.login(s1,s2)) != null) {
                    JOptionPane.showMessageDialog(jf, "登陆成功");
                    new UserSelectFrame().show("用户："+ Who.user.getAccount());
                    JOptionPane.getFrameForComponent(jf).dispose();
                }else {
                    JOptionPane.showMessageDialog(jf, "用户名密码不匹配");
                }
//

            }
        });
    }

    public void init() {
        jf.add(JLAccount);
        jf.add(JTAccount);
        jf.add(JLPassword);
        jf.add(JP);
        jf.add(JBClear);
        jf.add(JBEnter);

    }

    public void show() {
        init();
        jf.setResizable(false);
        actionHandle();
        jf.setLayout(new FlowLayout());
        jf.setBounds(300, 300, 407, 178);
        jf.setVisible(true);
//        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new UserLoginFrame().show();
    }

}
