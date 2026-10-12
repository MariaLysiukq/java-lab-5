package ua.opnu.view;

import ua.opnu.model.DrawShape;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class DrawFrame extends JFrame {

    private PaintSurface surface;

    public DrawFrame(String title) {
        super(title);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        // Створюємо поверхню малювання
        surface = new PaintSurface();
        
        // Додаємо панель з кнопками та область малювання у вікно
        this.add(setButtonPanel(), BorderLayout.NORTH);
        this.add(surface, BorderLayout.CENTER);
        
        this.pack();
        this.setVisible(true);
    }

    private JPanel setButtonPanel() {
        JPanel buttonPanel = new JPanel(true);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(Color.CYAN);
        buttonPanel.setBorder(new LineBorder(Color.BLACK, 2));

        BigTextButton rect = new BigTextButton("Rectangle");
        rect.addActionListener(e -> surface.setShapeType(DrawShape.SHAPE_RECTANGLE));
        buttonPanel.add(rect);

        BigTextButton rounded_rect = new BigTextButton("Rounded rect.");
        rounded_rect.addActionListener(e -> surface.setShapeType(DrawShape.SHAPE_ROUNDED_RECT));
        buttonPanel.add(rounded_rect);

        BigTextButton ellipse = new BigTextButton("Ellipse");
        // Використовуємо 2 як ідентифікатор для еліпса (замість відсутньої SHAPE_ELLIPSE)
        ellipse.addActionListener(e -> surface.setShapeType(2)); 
        buttonPanel.add(ellipse);

        BigTextButton clearBtn = new BigTextButton("Clear");
        clearBtn.addActionListener(e -> surface.clearShapes());
        buttonPanel.add(clearBtn);

        return buttonPanel;
    }
}
