package edu.CS542Project;


import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MenuDemo extends Application {

    private GameMenu gameMenu;

    private Stage primaryStage;


    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("LABYRINTH MAZE");

        Pane root = new Pane();

        root.setPrefSize(800,600);
        InputStream is = Files.newInputStream(Paths.get("C:\\Users\\maris\\IdeaProjects\\LabyrinthGame\\src\\images\\Maze1.jpg"));
        Image img = new Image(is);

        is.close();

        ImageView imgView = new ImageView(img);
        imgView.setFitWidth(800);
        imgView.setFitHeight(600);

        gameMenu = new GameMenu();


        gameMenu.setVisible(false);



        root.getChildren().addAll(imgView, gameMenu);

        Scene scene = new Scene(root);

        FadeTransition ft = new FadeTransition(Duration.seconds(0.5), gameMenu);
        ft.setFromValue(0);
        ft.setToValue(1);

        gameMenu.setVisible(true);
        ft.play();


        primaryStage.setScene(scene);
        primaryStage.show();

    }



    public class GameMenu extends Parent {

        public GameMenu(){

            VBox menu0 = new VBox(10);
            VBox menu1 = new VBox(10);
            VBox menu2 = new VBox(10);
            VBox menu3 = new VBox(10);
            VBox menu4 = new VBox(10);

            menu0.setTranslateX(100);
            menu0.setTranslateY(200);

            menu1.setTranslateX(100);
            menu1.setTranslateY(200);

            menu2.setTranslateX(100);
            menu2.setTranslateY(200);

            menu3.setTranslateX(100);
            menu3.setTranslateY(200);

            menu4.setTranslateX(100);
            menu4.setTranslateY(200);



            final int offset = 400;
            menu1.setTranslateX(offset);

            MenuButton btnResume = new MenuButton("RESUME");

            btnResume.setOnMouseClicked(mouseEvent -> {
                FadeTransition ft = new FadeTransition(Duration.seconds(0.5), this);
                ft.setFromValue(1);
                ft.setToValue(0);
                ft.setOnFinished((actionEvent -> setVisible(false)));
                ft.play();


                try {
                    FileWriter writer = new FileWriter("C:\\Users\\maris\\IdeaProjects\\LabyrinthGame\\src\\images\\State.txt", true);
                    writer.write("RESUME"+"\n");
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                primaryStage.close();


            });



            MenuButton btnNewGame = new MenuButton("NEW GAME");
            btnNewGame.setOnMouseClicked(mouseEvent -> {
                getChildren().add(menu1);
                TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu0);
                tt.setToX(menu0.getTranslateX() - offset);

                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu1);
                tt1.setToX(menu0.getTranslateX());

                tt.play();
                tt1.play();

                tt.setOnFinished(actionEvent -> {
                    getChildren().remove(menu0);


                });
            });

            MenuButton btnExit = new MenuButton("EXIT");
            btnExit.setOnMouseClicked(mouseEvent -> {
                System.exit(0);
            });

            MenuButton btnBack = new MenuButton("BACK");
            btnBack.setOnMouseClicked(mouseEvent -> {
                getChildren().add(menu0);

                TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu1);
                tt.setToX(menu1.getTranslateX() + offset);

                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu0);
                tt1.setToX(menu1.getTranslateX());

                tt.play();
                tt1.play();

                tt.setOnFinished(actionEvent -> {
                    getChildren().remove(menu1);
                });
            });

            MenuButton btnBack1 = new MenuButton("BACK");
            btnBack1.setOnMouseClicked(mouseEvent -> {
                getChildren().add(menu1);

                TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu2);
                tt.setToX(menu2.getTranslateX() + offset);

                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu1);
                tt1.setToX(menu2.getTranslateX());

                tt.play();
                tt1.play();

                tt.setOnFinished(actionEvent -> {
                    getChildren().remove(menu2);
                });
            });

            MenuButton btnBack2 = new MenuButton("BACK");
            btnBack2.setOnMouseClicked(mouseEvent -> {
                getChildren().add(menu2);

                TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu3);
                tt.setToX(menu3.getTranslateX() + offset);

                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu2);
                tt1.setToX(menu3.getTranslateX());

                tt.play();
                tt1.play();

                tt.setOnFinished(actionEvent -> {
                    getChildren().remove(menu3);
                });
            });

            MenuButton btnBack3 = new MenuButton("BACK");
            btnBack3.setOnMouseClicked(mouseEvent -> {
                getChildren().add(menu3);

                TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu4);
                tt.setToX(menu4.getTranslateX() + offset);

                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu3);
                tt1.setToX(menu4.getTranslateX());

                tt.play();
                tt1.play();

                tt.setOnFinished(actionEvent -> {
                    getChildren().remove(menu4);
                });
            });



            MenuButton btnPlayer = new MenuButton("CHOOSE PLAYER");
            btnPlayer.setOnMouseClicked(mouseEvent -> {
                getChildren().add(menu2);
                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.25), menu1);
                tt1.setToX(menu1.getTranslateX() - offset);

                TranslateTransition tt2 = new TranslateTransition(Duration.seconds(0.5), menu2);
                tt2.setToX(menu1.getTranslateX());

                tt1.play();
                tt2.play();

                tt1.setOnFinished(actionEvent -> {
                    getChildren().remove(menu1);


                });
            });

            MenuButton btnWizard = new MenuButton("WIZARD");
            btnWizard.setOnMouseClicked(mouseEvent -> {
                getChildren().add(menu3);
                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.25), menu2);
                tt1.setToX(menu2.getTranslateX() - offset);

                TranslateTransition tt2 = new TranslateTransition(Duration.seconds(0.5), menu3);
                tt2.setToX(menu2.getTranslateX());

                tt1.play();
                tt2.play();

                tt1.setOnFinished(actionEvent -> {
                    getChildren().remove(menu2);


                });
            });

            MenuButton btnKnight = new MenuButton("KNIGHT");
            btnKnight.setOnMouseClicked(mouseEvent -> {
                getChildren().add(menu3);
                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.25), menu2);
                tt1.setToX(menu2.getTranslateX() - offset);

                TranslateTransition tt2 = new TranslateTransition(Duration.seconds(0.5), menu3);
                tt2.setToX(menu2.getTranslateX());

                tt1.play();
                tt2.play();

                tt1.setOnFinished(actionEvent -> {
                    getChildren().remove(menu2);


                });
            });


            MenuButton btnHood = new MenuButton("HOOD");
            btnHood.setOnMouseClicked(mouseEvent -> {
                getChildren().add(menu4);
                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.25), menu3);
                tt1.setToX(menu3.getTranslateX() - offset);

                TranslateTransition tt2 = new TranslateTransition(Duration.seconds(0.5), menu4);
                tt2.setToX(menu3.getTranslateX());

                tt1.play();
                tt2.play();

                tt1.setOnFinished(actionEvent -> {
                    getChildren().remove(menu3);


                });
            });
            MenuButton btnCap = new MenuButton("CAP");
            btnCap.setOnMouseClicked(mouseEvent -> {
                getChildren().add(menu4);
                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.25), menu3);
                tt1.setToX(menu3.getTranslateX() - offset);

                TranslateTransition tt2 = new TranslateTransition(Duration.seconds(0.5), menu4);
                tt2.setToX(menu3.getTranslateX());

                tt1.play();
                tt2.play();

                tt1.setOnFinished(actionEvent -> {
                    getChildren().remove(menu3);


                });
            });
            MenuButton btnShield = new MenuButton("SHIELD");
            MenuButton btnJagger = new MenuButton("JAGGER");

            menu0.getChildren().addAll(btnResume, btnNewGame, btnExit);
            menu1.getChildren().addAll(btnBack,btnPlayer);
            menu2.getChildren().addAll(btnBack1, btnWizard, btnKnight);
            menu3.getChildren().addAll(btnBack2, btnHood, btnCap);
            menu4.getChildren().addAll(btnBack3, btnShield, btnJagger);

            Rectangle bg = new Rectangle(800,600);
            bg.setFill(Color.GREY);
            bg.setOpacity(0.4);
            getChildren().addAll(bg,menu0);
        }




    }
    private static class MenuButton extends StackPane {
        private Text text;
        public MenuButton(String name){
            text = new Text(name);
            text.setFont(text.getFont().font(20));
            text.setFill(Color.WHITE);

            Rectangle bg = new Rectangle(250,30);
            bg.setOpacity(0.6);
            bg.setFill(Color.DARKGREEN);
            bg.setEffect(new GaussianBlur(3.5));

            setAlignment(Pos.CENTER_LEFT);
            setRotate(-0.5);
            getChildren().addAll(bg, text);

            setOnMouseEntered(mouseEvent -> {
                bg.setTranslateX(10);
                text.setTranslateX(10);
                bg.setFill(Color.LIGHTGREEN);
                text.setFill(Color.DARKGREEN);
            });

            setOnMouseExited(mouseEvent -> {
                bg.setTranslateX(0);
                text.setTranslateX(0);
                bg.setFill(Color.DARKGREEN);
                text.setFill(Color.WHITE);
            });

            DropShadow drop = new DropShadow(50, Color.WHITE);
            drop.setInput(new Glow());

            setOnMousePressed(mouseEvent -> setEffect(drop));
            setOnMouseReleased(mouseEvent -> setEffect(null));
        }
    }


    public void main(String[] args){
        MenuMusicSingleton m1 = MenuMusicSingleton.getIntance();
        m1.play();

        launch(args);
//

        m1.stop();

    }
}
