package org.academiadecodigo.codezillas;

import org.academiadecodigo.codezillas.gameObjects.CollisionDetector;
import org.academiadecodigo.codezillas.gameObjects.Position;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class Player {

    private Position pos;
    private Picture playerImage;
    private PlayerInputs playerInputs = new PlayerInputs(new MovementLogic(this));
    private boolean falling = true;
    private boolean dead;

    Player(int col, int row) {
        pos = new Position(col, row);
        playerImage = new Picture(pos.colToX(), pos.rowToY(), AssetPaths.PLAYER_RIGHT);
    }

    boolean isDead() {
        return dead;
    }

    private void setFalling(boolean fly) {
        falling = fly;
    }

    public Position getPos() {
        return pos;
    }

    Picture getPlayerImage() {
        return playerImage;
    }

    void draw() {
        playerImage.draw();
    }

    private void playerFall() {
        pos.setRow(pos.getRow() + 1);
        playerImage.translate(0, Canvas.CELL_SIZE);
    }

    private void jump() {
        int jumpSize = 4;

        for (int i = 0; i < jumpSize; i++) {
            if (CollisionDetector.intersectsPlatform(1)) {
                setFalling(true);
                return;
            }

            if (pos.rowToY() - Canvas.CELL_SIZE == 0) {
                return;
            }
            pos.setRow(pos.getRow() - 1);
            playerImage.translate(0, -Canvas.CELL_SIZE);
        }
        setFalling(true);
    }


    private void moveRight() {
        //TODO: THE NUMBERS, MASON! WHAT DO THEY MEAN!?
        if (this.getPos().getCol() == 29) {
            return;
        }
        if (CollisionDetector.intersectsPlatform(3)) {
            return;
        }
        pos.setCol(pos.getCol() + 1);
        playerImage.load(AssetPaths.PLAYER_RIGHT);
        playerImage.translate(Canvas.CELL_SIZE, 0);
    }

    private void moveLeft() {
        if (this.getPos().getCol() == 0) {
            return;
        }

        if (CollisionDetector.intersectsPlatform(2)) {
            return;
        }

        pos.setCol(pos.getCol() - 1);
        playerImage.load(AssetPaths.PLAYER_LEFT);
        playerImage.translate(-Canvas.CELL_SIZE, 0);
    }

    void playerMove() {
        if (CollisionDetector.intersectsPlatform(0)) {
            setFalling(false);
            return;
        } else {
            setFalling(true);
        }

        if (falling) {
            this.playerFall();
        } else {
            this.jump();
        }
    }

    public void setDead(boolean dead) {
        this.dead = dead;

    }

    public Rectangle playerBounds() {
        return new Rectangle(this.pos.colToX(), this.pos.rowToY(), 40, 40);
    }

    private class PlayerInputs {

        private PlayerInputs(KeyboardHandler movementLogic) {

            Keyboard keyboard = new Keyboard(movementLogic);

            KeyboardEvent space = new KeyboardEvent();
            KeyboardEvent left = new KeyboardEvent();
            KeyboardEvent right = new KeyboardEvent();

            space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

            left.setKey(KeyboardEvent.KEY_LEFT);
            right.setKey(KeyboardEvent.KEY_RIGHT);
            space.setKey(KeyboardEvent.KEY_SPACE);

            keyboard.addEventListener(space);
            keyboard.addEventListener(left);
            keyboard.addEventListener(right);
        }
    }

    public class MovementLogic implements KeyboardHandler {

        private Player player;

        private MovementLogic(Player player) {
            this.player = player;
        }

        @Override
        public void keyPressed(KeyboardEvent keyboardEvent) {

            if (keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT) {
                player.moveLeft();
            }

            if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT) {
                player.moveRight();
            }

            if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
                player.jump();
            }

        }

        @Override
        public void keyReleased(KeyboardEvent keyboardEvent) {
        }
    }
}
