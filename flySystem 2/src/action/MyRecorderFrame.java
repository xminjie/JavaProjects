package action;

import entity.RecorderMore;
import factory.ObjectFactory;
import service.serviceProxy.FlightServiceProxyImp;
import service.serviceProxy.RecorderServiceProxyImp;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.Vector;

public class MyRecorderFrame {
    private JFrame jf;
    private JPanel panelN;
    private JPanel panelS;
    private JTable jTable;
    private JButton JBModify, JBReturn;


    public MyRecorderFrame() {
        jf = new JFrame("我的订单"+Who.user.getAccount());

        panelS = new JPanel();

        JBModify = new JButton("改签");
        JBReturn = new JButton("退票");


    }

    private void init() {
        panelS.add(JBModify);
        panelS.add(JBReturn);


        jTable = new JTable();

        JScrollPane jsp = new JScrollPane(jTable);
        jf.add(jsp);

        jf.add(panelS, BorderLayout.SOUTH);

    }
    private void initData() {
        RecorderServiceProxyImp recorderServiceProxyImp = (RecorderServiceProxyImp)ObjectFactory.getObject("RecorderServiceProxyImp");
        addData(recorderServiceProxyImp.query());
    }


    private void addData(List<RecorderMore> list) {
        System.out.println(list.size());
        DefaultTableModel def = new DefaultTableModel();
        def.addColumn("订单号");
        def.addColumn("航班号");
        def.addColumn("用户");

        def.addColumn("出发地");
        def.addColumn("目的地");
        def.addColumn("出发时间");
        def.addColumn("行程时间");
        def.addColumn("票价");

        def.addColumn("首次订票");
        def.addColumn("改签票");
        def.addColumn("是否退票");
        jTable.setModel(def);

        for(int i = 0; i < list.size(); i++){
            System.out.println(list.size());
            System.out.println(list.get(0)== null);
            RecorderMore recorderMore = (RecorderMore) list.get(i);
            System.out.println(recorderMore.toString());
            Vector<Object> v = new Vector<>();
            v.add(recorderMore.getRecorderId());
            v.add(recorderMore.getFlightId());
            v.add(recorderMore.getAccount());

            v.add(recorderMore.getBeginAddress());
            v.add(recorderMore.getEndAddress());
            v.add(recorderMore.getBeginTime());
            v.add(recorderMore.getTime());
            v.add(recorderMore.getPrice());

            v.add(recorderMore.getStatus1());
            v.add(recorderMore.getStatus2());
            v.add(recorderMore.getStatus3());
            System.out.println(v.size());
            def.addRow(v);
        }
        jTable.setModel(def);
    }


    private void actionHandle() {

        JBModify.addActionListener(e -> {
            FlightServiceProxyImp flightServiceProxyImp = (FlightServiceProxyImp) ObjectFactory.getObject("FlightServiceProxyImp");
            RecorderServiceProxyImp recorderServiceProxyImp = (RecorderServiceProxyImp)ObjectFactory.getObject("RecorderServiceProxyImp");
            int i = jTable.getSelectedRow();
            String  newFlightId = JOptionPane.showInputDialog("请输入新航班号");
            recorderServiceProxyImp.change(jTable.getValueAt(i,0).toString(),newFlightId);
            flightServiceProxyImp.flightTikectsChange(jTable.getValueAt(i,8).toString(),1);
            flightServiceProxyImp.flightTikectsChange(newFlightId,-1);
            initData();
            JOptionPane.showMessageDialog(jTable,"改签成功");

        });

        JBReturn.addActionListener(e -> {
            RecorderServiceProxyImp recorderServiceProxyImp = (RecorderServiceProxyImp)ObjectFactory.getObject("RecorderServiceProxyImp");
            FlightServiceProxyImp flightServiceProxyImp = (FlightServiceProxyImp) ObjectFactory.getObject("FlightServiceProxyImp");
            int i = jTable.getSelectedRow();
            recorderServiceProxyImp.back(jTable.getValueAt(i,0).toString());
            JOptionPane.showMessageDialog(jTable,"退票成功");
            flightServiceProxyImp.flightTikectsChange(jTable.getValueAt(i,1).toString(),1);
            initData();
        });


    }
    public void show() {
        init();
        initData();
        actionHandle();
        jf.setBounds(150, 300, 1000, 480);
        jf.setVisible(true);
//        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Who.user.setAccount("aaa");
        new MyRecorderFrame().show();
    }
}
