package action;

import entity.User;
import factory.ObjectFactory;
import service.serviceProxy.UserServiceProxyImp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserRegisterFrame {

    private JFrame jf;
    private JLabel JLaccount, JLname, JLidentityId, JLtel, JLemail, JLaddress, JLsex, JLPassword1, JLPassword2;
    private JTextField JTaccount, JTname, JTidentityId, JTtel, JTemail, JTaddress, JTSex;
    private JPasswordField JP1, JP2;
    private JButton JBEnter, JBClear;

    UserRegisterFrame() {
        jf = new JFrame();
        JLaccount = new JLabel("账户      （必填）");
        JLname = new JLabel("真实姓名（必填）");
        JLidentityId = new JLabel("身份证号（必填）");
        JLsex = new JLabel("性别      （必填）");
        JLemail = new JLabel("电子邮箱（选填）");
        JLaddress = new JLabel("家庭住址（选填）");
        JLtel = new JLabel("电话      （选填）");
        JLPassword1 = new JLabel("密码      （必填）");
        JLPassword2 = new JLabel("密码确认（必填）");

        JTaccount = new JTextField(10);
        JTname = new JTextField(10);
        JTidentityId = new JTextField(10);
        JTtel = new JTextField(10);
        JTemail = new JTextField(10);
        JTaddress = new JTextField(10);
        JTSex = new JTextField(10);

        JP1 = new JPasswordField(10);
        JP2 = new JPasswordField(10);

        JBClear = new JButton("重置");
        JBEnter = new JButton("确定");

    }

    public void actionHandle() {
        JBClear.addActionListener(e -> {
            JTaccount.setText(null);
            JTname.setText(null);
            JTidentityId.setText(null);
            JTtel.setText(null);
            JTemail.setText(null);
            JTaddress.setText(null);
            JTSex.setText(null);

            JP1.setText(null);
            JP2.setText(null);
        });

        JBEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                验证信息输入格式
//                调用注册方法

                User user = new User();
                user.setAccount(JTaccount.getText());
                user.setPassword(JP1.getText());
                user.setName(JTname.getText());
                user.setIdentityId(JTidentityId.getText());
                user.setSex(JTSex.getText());
                user.setTel(JTtel.getText());
                user.setAddress(JTaddress.getText());
                user.setEmail(JTemail.getText());

                UserServiceProxyImp userServiceProxyImp = (UserServiceProxyImp) ObjectFactory.getObject("UserServiceProxyImp");
                if (userServiceProxyImp.register(user) != null) {
                    JOptionPane.showMessageDialog(jf, "注册成功,请登录");
                    JOptionPane.getFrameForComponent(jf).dispose();
                } else {
                    JOptionPane.showMessageDialog(jf, "账户已存在");
                }

            }
        });

    }

    public void init() {


        jf.add(JLaccount);
        jf.add(JTaccount);
        jf.add(JLPassword1);
        jf.add(JP1);
        jf.add(JLPassword2);
        jf.add(JP2);
        jf.add(JLname);
        jf.add(JTname);
        jf.add(JLidentityId);
        jf.add(JTidentityId);
        jf.add(JLsex);
        jf.add(JTSex);

        jf.add(JLtel);
        jf.add(JTtel);
        jf.add(JLemail);
        jf.add(JTemail);
        jf.add(JLaddress);
        jf.add(JTaddress);

        jf.add(JBClear);
        jf.add(JBEnter);

    }

    public void show() {
        init();
        jf.setResizable(false);
        actionHandle();
        jf.setLayout(new FlowLayout());
        jf.setBounds(300, 300, 276, 402);
        jf.setVisible(true);
//        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new UserRegisterFrame().show();
    }
}
