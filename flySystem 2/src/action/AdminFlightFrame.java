package action;

import entity.Flight;
import factory.ObjectFactory;
import service.serviceProxy.FlightServiceProxyImp;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class AdminFlightFrame {
    private JFrame jf;



    private JTable jTable;

    private JPanel panelN, panelS;

    private JButton JBAdd, JBRemove, JBModify, JBQuery;

    private JLabel JLFlight, JLBegin, JLEnd;

    private JTextField JTFlight, JTBegin, JTEnd;


    AdminFlightFrame() {
        jf = new JFrame("用户订票");

        jTable = new JTable();

        panelN = new JPanel();
        panelS = new JPanel();

        JLFlight = new JLabel("航班号");
        JLBegin = new JLabel("出发地");
        JLEnd = new JLabel("目的地");

        JTFlight = new JTextField(10);
        JTBegin = new JTextField(10);
        JTEnd = new JTextField(10);


        JBAdd = new JButton("添加航班");
        JBModify = new JButton("修改航班");
        JBRemove = new JButton("删除航班");
        JBQuery = new JButton("查询余票");


    }

    private void init() {
        panelS.add(JBAdd);
        panelS.add(JBModify);
        panelS.add(JBRemove);
        panelS.add(JBQuery);

        panelN.add(JLFlight);
        panelN.add(JTFlight);
        panelN.add(JLBegin);
        panelN.add(JTBegin);
        panelN.add(JLEnd);
        panelN.add(JTEnd);

        JScrollPane jsp = new JScrollPane(jTable);
        jf.add(jsp);

        jf.add(panelN, BorderLayout.NORTH);
        jf.add(panelS, BorderLayout.SOUTH);

    }


    private void initData() {
        FlightServiceProxyImp flightServiceProxyImp = (FlightServiceProxyImp)ObjectFactory.getObject("FlightServiceProxyImp");
//        此处调用的
        addData(flightServiceProxyImp.queryAll());
        System.out.println("调用in");
    }


    private void addData(List<Flight> list) {
        DefaultTableModel def = new DefaultTableModel();
        def.addColumn("航班号");
        def.addColumn("出发地");
        def.addColumn("目的地");
        def.addColumn("出发时间");
        def.addColumn("行程时间");
        def.addColumn("余票");
        def.addColumn("票价");

        for(int i = 0; i < list.size(); i++){
            Flight f = list.get(i);
            Vector<Object> v = new Vector<>();
            v.add(f.getFlightId());
            v.add(f.getBeginAddress());
            v.add(f.getEndAddress());
            v.add(f.getBeginTime());
            v.add(f.getTime());
            v.add(f.getAvailableTickets());
            v.add(f.getPrice());
            def.addRow(v);
        }
        jTable.setModel(def);
    }


    private void actionHandle() {
        JBAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddFlightFrame().show();
            }
        });


        JBModify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FlightServiceProxyImp flightServiceProxyImp = (FlightServiceProxyImp) ObjectFactory.getObject("FlightServiceProxyImp");
                Integer i = jTable.getSelectedRow();
                Who.flight.setFlightId(jTable.getValueAt(i, 0).toString());
                Who.flight.setBeginAddress(jTable.getValueAt(i, 1).toString());
                Who.flight.setEndAddress(jTable.getValueAt(i, 2).toString());
                Who.flight.setBeginTime(jTable.getValueAt(i, 3).toString());
                Who.flight.setTime(Integer.parseInt(jTable.getValueAt(i, 4).toString()));
                Who.flight.setAvailableTickets(Integer.parseInt(jTable.getValueAt(i, 5).toString()));
                Who.flight.setPrice(Float.parseFloat(jTable.getValueAt(i, 6).toString()));
                if (i != null) {
                    System.out.println(Who.flight.toString());
                    new ModifyFlightFrame().show();
                    AdminFlightFrame.this.initData();
                }
            }
        });
        JBRemove.addActionListener(e -> {
            FlightServiceProxyImp flightServiceProxyImp = (FlightServiceProxyImp)ObjectFactory.getObject("FlightServiceProxyImp");
            Flight f = new Flight();
            int [] array = jTable.getSelectedRows();
            for(int i : array) {
                f.setFlightId(jTable.getValueAt(i,0).toString());
                flightServiceProxyImp.flightDelete(f);
                initData();
            }
        });


        JBQuery.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FlightServiceProxyImp flightServiceProxyImp = (FlightServiceProxyImp) ObjectFactory.getObject("FlightServiceProxyImp");
                Flight f = new Flight();
                f.setFlightId(JTFlight.getText());
                f.setBeginAddress(JTBegin.getText());
                f.setEndAddress(JTEnd.getText());
                AdminFlightFrame.this.addData(flightServiceProxyImp.queryAll(f));
            }
        });
    }

    void show(String s) {
        jf.setTitle(s);
        init();
        initData();
        actionHandle();
//        jf.setLayout(new FlowLayout());
        jf.setBounds(300, 300, 737, 421);
        jf.setVisible(true);
//        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new AdminFlightFrame().show("admin1");
    }
}
