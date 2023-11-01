
import java.util.Random;

import org.joml.Vector3f;

import main.*;
import modeling.Mash;
import modeling.Model;
import modeling.ModelShape;

public class BadMincraftClone extends Scene{

    public static void main(String[] args){
        Window.scenes = new Scene[2];
        Window.scenes[0] = new BadMincraftClone();
        new Window(920,720,"mincraft");
    }

    private int sizeX = 30;
    private int sizeY = 30;
    private int sizeZ = 30;

    private int posX = 0;
    private int posY = 0;
    private int posZ = 0;

    private Mash m;
    private float[] vertex;

    private Model lineCube;
    

    public void init() {
        Entity g = new Entity();
        vertex = new float[sizeX * sizeY * sizeZ * VertexsieFile.cubeVertex().length];
        m = new Mash(vertex, "dirt");
        
        g.addComponent(new Model(m, 0, 0, 0));

        g = new Entity();
        lineCube = new Model(new Mash(VertexsieFile.cubeLineVertex(), "dirt"), 0,0,0);
        lineCube.setModelShape(ModelShape.Lines);
        g.addComponent(lineCube);
        g = new Entity();
        Model brder = new Model(new Mash(VertexsieFile.cubeLineVertex(), "dirt")
        , sizeX/2.0f - 0.5f,sizeY/2.0f - 0.5f,sizeZ/2.0f - 0.5f);
        brder.setScale(sizeX,sizeY,sizeZ);
        brder.setModelShape(ModelShape.Lines);
        g.addComponent(brder);

        for (int x = 0; x < sizeX; x++) {
            posX = x;
            for (int z = 0; z < sizeZ; z++) {
                posZ = z;
                for (int y = 0; y < 5; y++) {
                    posY = y;
                    placeBlack();
                }
            }
        }

        cam.setPos(sizeX * 2,sizeY * 2, sizeZ * 2);
        cam.setAngle(-45, -45, 0);
        cam.setOrtho(20);
        
    }
    
    public void update(float dt) {
        camControler(dt);
        Controler();

        if(Input.getKeyPressNow("k")){
            placeBlack();
        }
    }

    private void placeBlack(){
        int posAdd = (posX + posY * sizeX + posZ * sizeX * sizeY) * VertexsieFile.cubeVertex().length;
        for (int i = posAdd; i < VertexsieFile.cubeVertex().length + posAdd; i++) {
            vertex[i] = VertexsieFile.cubeVertex()[i%VertexsieFile.cubeVertex().length];
            if(i%10 == 0){
                vertex[i] += posX;
            }
            if(i%10 == 1){
                vertex[i] += posY;
            }
            if(i%10 == 2){
                vertex[i] += posZ;
            }
        }
        m.setVertices(vertex);
        System.out.println("x:" + posX + " y:" + posY + " z:" + posZ);
    }

    private void Controler(){
        if(Input.getKeyPressNow("right")){
            posX ++;
        }
        if(Input.getKeyPressNow("left")){
            posX --;
        }
        if(Input.getKeyPressNow("up")){
            posY ++;
        }

        if(Input.getKeyPressNow("down")){
            posY --;
        }
        if(Input.getKeyPressNow("n")){
            posZ --;
        }
        if(Input.getKeyPressNow("m")){
            posZ ++;
        }
        lineCube.setPos(posX, posY, posZ);
    }

    private void camControler(float dt){
        if(!cam.getIsOrtho()){

            float x = 0;
            float y = 0;
            
            if(Input.getKeyPress("w")){
                x += 5.0f;
            }
            if(Input.getKeyPress("s")){
                x -= 5.0f;
            }
            if(Input.getKeyPress("a")){
                y += 5.0f;
            }
            if(Input.getKeyPress("d")){
                y -= 5.0f;
            }
            cam.getPos().add(cam.getLookDir().mul(x * dt,new Vector3f()));
            cam.setAngle(cam.getAngleX(), cam.getAngleY() + 90, cam.getAngleZ());
            cam.getPos().add(cam.getLookDir().mul(y * dt,new Vector3f()));
            cam.setAngle(cam.getAngleX(), cam.getAngleY() - 90, cam.getAngleZ());

            float angleX = 0;
            float angleY = 0;

            if(Input.getKeyPress("q")){
                angleX += 90.0f;
            }
            if(Input.getKeyPress("e")){
                angleX -= 90.0f;
            }
            if(Input.getKeyPress("z")){
                angleY -= 90.0f;
            }
            if(Input.getKeyPress("x")){
                angleY += 90.0f;
            }

            cam.setAngle(cam.getAngleX() + angleX * dt, cam.getAngleY() + angleY * dt,cam.getAngleZ());
        }
        else{
            float x = 0;
            float y = 0;
            float speed = 10;
            
            if(Input.getKeyPress("w")){
                x += speed;
            }
            if(Input.getKeyPress("s")){
                x -= speed;
            }
            if(Input.getKeyPress("a")){
                y -= speed;
            }
            if(Input.getKeyPress("d")){
                y += speed;
            }
            cam.getPos().add(new Vector3f(y * dt*0.5f,x * dt,-y * dt*0.5f));
        }

        if(Input.getKeyPressNow("r")){
            if(cam.getIsOrtho()){
                cam.setPos(sizeX,sizeY, sizeZ);
                cam.setAngle(-45, -45, 0);
                cam.setPerspective();
            }
            else{
                cam.setPos(sizeX * 2,sizeY * 2, sizeZ * 2);
                cam.setAngle(-45, -45, 0);
                cam.setOrtho(20);
            }
        }
    }

}
