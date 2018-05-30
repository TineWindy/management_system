package gymnastics_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static javax.swing.JLayeredPane.DEFAULT_LAYER;
import static javax.swing.JLayeredPane.DRAG_LAYER;

public class LoginIn
{
    JTextField username=new JTextField();
    JTextField password=new JTextField();

    JButton loginbutton=new JButton("登录");
    JButton registerbutton=new JButton("注册");
    public void LoginInwindow()
    {

        JFrame frame=new JFrame("登录界面");
        JLayeredPane layeredPane = new JLayeredPane();

        JPanel fieldpanel=new JPanel();
        fieldpanel.setLayout(new GridLayout(2,2));
        JPanel buttons=new JPanel();
        JPanel bgpicture=new JPanel();


        JLabel namel=new JLabel("用户名");
        JLabel passwordl=new JLabel("密码");

        //屏幕大小
        Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)screensize.getWidth();
        int height = (int)screensize.getHeight();

//        username.setSize(100,40);
//        password.setSize(200,40);

        //输入框
        fieldpanel.add(namel);
        fieldpanel.add(username);
        fieldpanel.add(passwordl);
        fieldpanel.add(password);

        fieldpanel.setBounds(height/2+100,width/4,300,80);

        //按钮
        loginbutton.addActionListener(new buttonListener());
        registerbutton.addActionListener(new buttonListener());
        buttons.add(loginbutton);
        buttons.add(registerbutton);

        buttons.setBounds(height/2+100,width/4+100,300,80);

        //背景图片
        ImageIcon logininpicture=new ImageIcon("logininpicture.jpg");
        logininpicture.setImage(logininpicture.getImage().getScaledInstance(width,height, Image.SCALE_DEFAULT));
        JLabel bgpicturel = new JLabel(logininpicture);
        bgpicture.add(bgpicturel);
        bgpicture.setBounds(0,0,width,height);

        //添加到分层器上
        layeredPane.add(fieldpanel,DRAG_LAYER);
        layeredPane.add(buttons,DRAG_LAYER);
        layeredPane.add(bgpicture,DEFAULT_LAYER);

        fieldpanel.setOpaque(false);
        buttons.setOpaque(false);

        frame.getContentPane().add(layeredPane);
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public void login()
    {
        DbConnect dbConnect=new DbConnect();
        Connection conn=dbConnect.connect();

        String sql="SELECT * from team WHERE Team_UserName=? AND Team_Password=?";
        try
        {
            String username_=username.getText();
            String password_=password.getText();
            PreparedStatement preparedStatement=conn.prepareStatement(sql);

            preparedStatement.setString(1,username_);
            preparedStatement.setString(2,password_);

            ResultSet rs=preparedStatement.executeQuery();

            if (rs.next())
            {
                JOptionPane.showMessageDialog(null,"登录成功");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"不存在该用户");
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public static void main(String[] args)
    {
        LoginIn loginIn=new LoginIn();
        loginIn.LoginInwindow();
    }

    class buttonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource()==loginbutton)
            {
                 login();
            }
            if (e.getSource()==registerbutton)
            {
                 Register register=new Register();
                 register.Registerwindow();
            }
        }
    }
}
