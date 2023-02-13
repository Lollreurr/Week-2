import Engine.Object2d;
import Engine.ShaderProgram;
import Engine.Window;
import org.lwjgl.opengl.GL;
import org.joml.Vector3f;

import java.util.Arrays;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;



public class Main {

    private Window window = new Window(800,800,"Hello World");
    private ArrayList<Object2d> Objects  = new ArrayList<>();


    public void init(){
        window.init();
        GL.createCapabilities();

        //code
        Objects.add(new Object2d()(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
            new ShaderProgram.ShaderModuleData("resources/shaders/scene/frag", GL_FRAGMENT_SHADER),
            new ArrayList<>(list.of(new Vector3f(0.0f,0.5f,0.0f),
                    new Vector3f(-0.5f,))))))
    }
    public void loop(){
        while(window.isOpen()){
            window.update();
            glClearColor(0.0f,0.0f,0.0f,0.0f);
            GL.createCapabilities();
            //code

            //restore state
            glDisableVertexAttribArray(0);

            //poll for window events.
            //the key callback above will only be
            //invoked during this call.
            glfwPollEvents();

        }
    }
    public void run(){
        init();
        loop();

        // terminate GLFW and
        // free the error callback

        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    public static void main(String[] args) {
        System.out.println("hello world");
        new Main().run();

    }
}

