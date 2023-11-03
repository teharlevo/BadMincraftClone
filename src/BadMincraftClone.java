
import java.util.Random;

import org.joml.Vector3f;

import main.*;
import modeling.Mash;
import modeling.Model;
import modeling.ModelShape;
import modeling.TextMash;

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

    private int bloackNum = 0;
    private int bloacksNum = (int)(1.0f/VertexsieFile.texHight());

    private Mash m;
    private float[] vertex;

    private Model lineCube;

    private String[] blockNames = new String[]{"dirt","grass","wood","cobblestone","brick wall","leaves","stone"};

    private Entity UIMaster;
    private TextMash posText;
    private TextMash blockText;

    public void init() {
        Entity g = new Entity();
        vertex = new float[sizeX * sizeY * sizeZ * VertexsieFile.cubeVertex().length];
        m = new Mash(vertex, "tileMap");
        
        g.addComponent(new Model(m, 0, 0, 0));

        g = new Entity();
        lineCube = new Model(new Mash(VertexsieFile.cubeLineVertex(), "tileMap"), 0,0,0);
        lineCube.setModelShape(ModelShape.Lines);
        g.addComponent(lineCube);
        g = new Entity();
        Model brder = new Model(new Mash(VertexsieFile.cubeLineVertex(), "tileMap")
        , sizeX/2.0f - 0.5f,sizeY/2.0f - 0.5f,sizeZ/2.0f - 0.5f);
        brder.setScale(sizeX,sizeY,sizeZ);
        brder.setModelShape(ModelShape.Lines);
        g.addComponent(brder);

        bloackNum = 0;
        for (int x = 0; x < sizeX; x++) {
            posX = x;
            for (int z = 0; z < sizeZ; z++) {
                posZ = z;
                for (int y = 0; y < 3; y++) {
                    posY = y;
                    placeBlack();

                }
            }
        }
        bloackNum = 1;
        for (int x = 0; x < sizeX; x++) {
            posX = x;
            for (int z = 0; z < sizeZ; z++) {
                posZ = z;
                for (int y = 3; y < 4; y++) {
                    posY = y;
                    placeBlack();
                }
            }
        }
        tallPos();

        cam.setPos(sizeX * 2,sizeY * 2, sizeZ * 2);
        cam.setAngle(-45, -45, 0);
        cam.setOrtho(20);

        UIMaster = new Entity();
        posText = new TextMash("x:" + posX + " y:" + posY + "z:" + posZ, "arial");
        float x = 8.0f;
        float y = -5.0f;
        Model uiModel = new Model(posText.getMash(),-y * 0.5f,-x,y * 0.5f);
        uiModel.setScale(7,7,7);
        uiModel.setAngle(0, 45, 0);
        UIMaster.addComponent(uiModel);

        blockText = new TextMash(blockNames[bloackNum],"arial");
        x = 9.0f;
        y = -5.0f;
        uiModel = new Model(blockText.getMash(),-y * 0.5f,-x,y * 0.5f);
        uiModel.setScale(7,7,7);
        uiModel.setAngle(0, 45, 0);
        UIMaster.addComponent(uiModel);
        
    }
    
    public void update(float dt) {
        camControler(dt);
        Controler();
        updateUI();

        if(Input.getKeyPressNow("o")){
            placeBlack();
            tallPos();
        }
        if(Input.getKeyPressNow("t")){
            killBlock();
            tallPos();
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
            if(i%10 == 8){
                vertex[i] += bloackNum * VertexsieFile.texHight();
            }
        }
        m.setVertices(vertex);
    }

    private void Controler(){
        boolean cange = false;
        int posAdd = (posX + posY * sizeX + posZ * sizeX * sizeY) * VertexsieFile.cubeVertex().length;
        for (int i = posAdd; i < VertexsieFile.cubeVertex().length + posAdd; i++) {
            if(i%10 == 4){
                vertex[i] = 1.0f;
            }
            if(i%10 == 5){
                vertex[i] = 1.0f;
            }
        }
        if(Input.getKeyPressNow("k") && posX != sizeX - 1){
            posX ++;
            cange = true;
        }
        if(Input.getKeyPressNow("h") && posX != 0){
            posX --;
            cange = true;
        }
        if(Input.getKeyPressNow("u")&& posY != sizeY - 1){
            posY ++;
            cange = true;
        }

        if(Input.getKeyPressNow("j") && posY != 0){
            posY --;
            cange = true;
        }
        if(Input.getKeyPressNow("i") && posZ != 0){
            posZ --;
            cange = true;
        }
        if(Input.getKeyPressNow("y")&& posZ != sizeZ - 1){
            posZ ++;
            cange = true;
        }

        for (int i = 0; i < bloacksNum; i++) {
            if(Input.getKeyPressNow(String.valueOf(i + 1))){
                bloackNum = i;
            }
        }

        if(!cange){return;}
        tallPos();
    }

    private void tallPos(){
        lineCube.setPos(posX, posY, posZ);

        int posAdd = (posX + posY * sizeX + posZ * sizeX * sizeY) * VertexsieFile.cubeVertex().length;
        for (int i = posAdd; i < VertexsieFile.cubeVertex().length + posAdd; i++) {
            
            if(i%10 == 5){
                vertex[i] = 0.0f;
            }
            if(i%10 == 4){
                vertex[i] = 0.0f;
            }
        }
        m.setVertices(vertex);
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

            //if(Input.getKeyPress("q")){
            //    angleX += 90.0f;
            //}
            //if(Input.getKeyPress("e")){
            //    angleX -= 90.0f;
            //}
            //if(Input.getKeyPress("z")){
            //    angleY -= 90.0f;
            //}
            //if(Input.getKeyPress("x")){
            //    angleY += 90.0f;
            //}
            angleX = ((float)Input.getMousePosY() / (float)Window.height() - 0.5f) * -180.0f;
            angleY = ((float)Input.getMousePosX() / (float)Window.width() - 0.5f) * 360.0f;
            cam.setAngle(angleX,angleY,cam.getAngleZ());

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
            UIMaster.pos = new Vector3f(cam.getPos().x,cam.getPos().y,cam.getPos().z);
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

    private void killBlock(){
        int posAdd = (posX + posY * sizeX + posZ * sizeX * sizeY) * VertexsieFile.cubeVertex().length;
        for (int i = posAdd; i < VertexsieFile.cubeVertex().length + posAdd; i++) {
            vertex[i] = 0;
        }
    }

    private void updateUI(){
        posText.cangeText("x:" + posX + " y:" + posY + "z:" + posZ);
        blockText.cangeText(blockNames[bloackNum]);
    }

}
