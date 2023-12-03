#type vertex
#version 430 core
layout (location=0) in vec3 aPos;
layout (location=1) in vec2 aTexCoords;
layout (location=2) in float blocktype;

uniform mat4 uView;
uniform mat4 uProjection;

uniform int sizeX;
uniform int sizeY;
uniform int sizeZ;

out vec4 fColor;
out vec2 fTexCoords;

void main()
{
    fColor = vec4(1);
    if(blocktype == 0){fColor = vec4(0,0,0,0);}
    //if(((blocktype*2)%2) == 1){fColor = vec4(1,0,0,1);}
    fTexCoords = vec2(aTexCoords.x, (blocktype-1)/7 +aTexCoords.y);
    vec3 pos = vec3((gl_InstanceID/sizeZ)%(sizeX),(gl_InstanceID/(sizeZ * sizeX))%(sizeY),gl_InstanceID%sizeZ);
    gl_Position = uProjection * uView * vec4(aPos + pos, 1.0);
}

#type fragment
#version 430 core

uniform sampler2D[8] uTex_Sampler;
uniform float time;

in vec4 fColor;
in vec2 fTexCoords;

out vec4 color;

void main()
{
    color = fColor * texture(uTex_Sampler[0], vec2(fTexCoords.x,fTexCoords.y ));
}