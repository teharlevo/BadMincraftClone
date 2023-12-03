
public class VertexsieFile {

    private static float texWuth =  1.0f/3.0f;
    private static float texHight = 1.0f/7.0f;

    private static float[] cubeVertex = new float[]{
        -0.5f, -0.5f,  0.5f,texWuth*1,     0.0f,
         0.5f, -0.5f,  0.5f,texWuth*2,     0.0f,
         0.5f,  0.5f,  0.5f,texWuth*2, texHight,
         0.5f,  0.5f,  0.5f,texWuth*2, texHight,
        -0.5f,  0.5f,  0.5f,texWuth*1, texHight,
        -0.5f, -0.5f,  0.5f,texWuth*1,     0.0f,

        -0.5f, -0.5f,  -0.5f,texWuth*1,     0.0f,
         0.5f, -0.5f,  -0.5f,texWuth*2,     0.0f,
         0.5f,  0.5f,  -0.5f,texWuth*2, texHight,
         0.5f,  0.5f,  -0.5f,texWuth*2, texHight,
        -0.5f,  0.5f,  -0.5f,texWuth*1, texHight,
        -0.5f, -0.5f,  -0.5f,texWuth*1,     0.0f,

        -0.5f, -0.5f,  -0.5f,0.0f,        0.0f,
         0.5f, -0.5f,  -0.5f,texWuth,     0.0f,
         0.5f, -0.5f,   0.5f,texWuth, texHight,
         0.5f, -0.5f,   0.5f,texWuth, texHight,
        -0.5f, -0.5f,   0.5f,0.0f,    texHight,
        -0.5f, -0.5f,  -0.5f,0.0f,        0.0f,

        -0.5f, 0.5f,  -0.5f,texWuth*2,        0.0f,
         0.5f, 0.5f,  -0.5f,texWuth*3,        0.0f,
         0.5f, 0.5f,   0.5f,texWuth*3,    texHight,
         0.5f, 0.5f,   0.5f,texWuth*3,    texHight,
        -0.5f, 0.5f,   0.5f,texWuth*2,    texHight,
        -0.5f, 0.5f,  -0.5f,texWuth*2,        0.0f,
        
        0.5f, -0.5f,  -0.5f,texWuth*1,     0.0f,
        0.5f, -0.5f,   0.5f,texWuth*2,     0.0f,
        0.5f,  0.5f,   0.5f,texWuth*2, texHight,
        0.5f,  0.5f,   0.5f,texWuth*2, texHight,
        0.5f,  0.5f,  -0.5f,texWuth*1, texHight,
        0.5f, -0.5f,  -0.5f,texWuth*1,     0.0f,

        -0.5f, -0.5f,  -0.5f,texWuth*1,     0.0f,
        -0.5f, -0.5f,   0.5f,texWuth*2,     0.0f,
        -0.5f,  0.5f,   0.5f,texWuth*2, texHight,
        -0.5f,  0.5f,   0.5f,texWuth*2, texHight,
        -0.5f,  0.5f,  -0.5f,texWuth*1, texHight,
        -0.5f, -0.5f,  -0.5f,texWuth*1,     0.0f,
    };

    private static float[] cubeLineVertex = new float[]{
        -0.501f, -0.501f,   0.501f,1.0f,0.0f,0.0f,1.0f,  0.0f, 0.0f,-1.0f,
        -0.501f, -0.501f,  -0.501f,1.0f,0.0f,0.0f,1.0f,  0.0f, 0.0f,-1.0f,

        0.501f, -0.501f,   0.501f, 1.0f,0.0f,0.0f,1.0f,  0.0f, 0.0f,-1.0f,
        0.501f, -0.501f,  -0.501f, 1.0f,0.0f,0.0f,1.0f,  0.0f, 0.0f,-1.0f,
        
        0.501f, 0.501f,   0.501f,  1.0f,0.0f,0.0f,1.0f,  0.0f, 0.0f,-1.0f,
        0.501f, 0.501f,  -0.501f,  1.0f,0.0f,0.0f,1.0f,  0.0f, 0.0f,-1.0f,

        -0.501f, 0.501f,   0.501f, 1.0f,0.0f,0.0f,1.0f,  0.0f, 0.0f,-1.0f,
        -0.501f, 0.501f,  -0.501f, 1.0f,0.0f,0.0f,1.0f,  0.0f, 0.0f,-1.0f,

        -0.501f,-0.501f,  -0.501f, 1.0f,0.0f,0.0f,1.0f,  0.0f, 0.0f,-1.0f,
        -0.501f,0.501f,   -0.501f, 1.0f,0.0f,0.0f,1.0f,  0.0f, 0.0f,-1.0f,
    
        -0.501f,-0.501f,   0.501f, 1.0f,0.0f,0.0f,1.0f,  0.0f, 0.0f,-1.0f,
        -0.501f,0.501f,    0.501f, 1.0f,0.0f,0.0f,1.0f,  0.0f, 0.0f,-1.0f,

         0.501f,-0.501f,  -0.501f, 1.0f,0.0f,0.0f,1.0f,  0.0f, 0.0f,-1.0f,
         0.501f,0.501f,   -0.501f, 1.0f,0.0f,0.0f,1.0f,  0.0f, 0.0f,-1.0f,
    
         0.501f,-0.501f,   0.501f, 1.0f,0.0f,0.0f,1.0f,  0.0f, 0.0f,-1.0f,
         0.501f,0.501f,    0.501f, 1.0f,0.0f,0.0f,1.0f,  0.0f, 0.0f,-1.0f,
         
        -0.501f,0.501f,   0.501f, 1.0f,0.0f,0.0f,1.0f,  0.0f, 0.0f,-1.0f,
        0.501f, 0.501f,    0.501f, 1.0f,0.0f,0.0f,1.0f,  0.0f, 0.0f,-1.0f,

        -0.501f,-0.501f,   0.501f, 1.0f,0.0f,0.0f,1.0f,  0.0f, 0.0f,-1.0f,
        0.501f, -0.501f,    0.501f, 1.0f,0.0f,0.0f,1.0f,  0.0f, 0.0f,-1.0f,

        -0.501f,0.501f,  -0.501f, 1.0f,0.0f,0.0f,1.0f,  0.0f, 0.0f,-1.0f,
        0.501f, 0.501f,  -0.501f, 1.0f,0.0f,0.0f,1.0f,  0.0f, 0.0f,-1.0f,
        
        -0.501f,-0.501f, -0.501f, 1.0f,0.0f,0.0f,1.0f,  0.0f, 0.0f,-1.0f,
        0.501f, -0.501f, -0.501f, 1.0f,0.0f,0.0f,1.0f,  0.0f, 0.0f,-1.0f,
    };

    public static float[] cubeVertex(){
        return cubeVertex;
    }

    public static float[] cubeLineVertex(){
        return cubeLineVertex;
    }

    public static float texHight(){
        return texHight;
    }
}
