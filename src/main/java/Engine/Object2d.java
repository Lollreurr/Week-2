package Engine;
import org.joml.Vector3f;

import java.util.List;
import java.util.Vector;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;


public class Object2d extends ShaderProgram{
    List<Vector3f> vertices;
    int vao;
    int vbo;

    public setupVAOVBO(){
        //set vao
        vao = glGenVertexArrays();
        glBindVertexArray(vao);

        //set vbo
        glBindBuffer(GL_ARRAY_BUFFER,vbo);
        glBufferData(GL_ARRAY_BUFFER,Utils.listofloat(vertices),GL_STATIC_DRAW);

    }
    public void draw(){
        drawSetup();
        // draw the vertices
        // optional
        glLineWidth(1);
        glPointSize(0);
        // wajib
        //GL_LINE
        //GL_LINE_STRIP
        //GL_LINE_LOOP
        //GL_TRIANGLES
        //GL_TRIANGLES_FAN
        //GL_POINT
        glDrawArrays(GL_TRIANGLES,0,vertices.size());
    }

    public void drawSetup(){
        bind();

        //bind VBO
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER,vbo);
        glVertexAttribPointer(0,3,GL_FLOAT,false,0,0);
}

}
