package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Sphere;
import com.jme3.system.AppSettings;


/**
 * This is the Main Class of your Game. You should only do initialization here.
 * Move your Logic into AppStates or Controls
 * @author normenhansen
 */
public class Main extends SimpleApplication {
    
    //declaramos Spacial para cada orbita y rotacion de los planetas
    public Spatial orbitaMercurio;
    public Spatial rotacionMercurio;
    
    public Spatial orbitaVenus;
    public Spatial rotacionVenus;
    
    public Spatial orbitaTierra;
    public Spatial rotacionTierra;
    
    public Spatial orbitaMarte;
    public Spatial rotacionMarte;
    
    public Spatial orbitaJupiter;
    public Spatial rotacionJupiter;

    public static void main(String[] args) {
        Main app = new Main();
        
        //creamos el objeto para controlar las especificaciones
        AppSettings settings = new AppSettings(true);
        settings.setTitle("Sistsema Solar");
        settings.setSettingsDialogImage("Interface/sisSolar1.jpg");
        settings.setFrameRate(20);
        app.setSettings(settings);
        
        app.start();
    }

    @Override
    public void simpleInitApp() {
        
        flyCam.setMoveSpeed(60f);
        
        //creamos las esferas para el Sol y los Planetas
        Sphere Sol = new Sphere(200, 200, 2);
        Sphere Mercurio = new Sphere(100, 100, 1);
        Sphere Venus = new Sphere(100, 100, 1);
        Sphere Tierra = new Sphere(100, 100, 1);
        Sphere Marte = new Sphere(100, 100, 1);
        Sphere Jupiter = new Sphere(100, 100, 1);
        
        //creamos la geometria el Solylos Planetas
        Geometry geomSol = new Geometry("Sol", Sol);
        Geometry geomMercurio = new Geometry("Mercurio", Mercurio);
        Geometry geomVenus = new Geometry("Venus", Venus);
        Geometry geomTierra = new Geometry("Tierra", Tierra);
        Geometry geomMarte = new Geometry("Marte", Marte);
        Geometry geomJupiter = new Geometry("Jupiter", Jupiter);
        
        //creamos un objeto para texturizar y se lo asignamos a los Planetas correespondientes
        Material matSol = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matSol.setTexture("ColorMap", assetManager.loadTexture("Textures/sol.jpg"));
        geomSol.setMaterial(matSol);
        
        Material matMercurio = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matMercurio.setTexture("ColorMap", assetManager.loadTexture("Textures/mercurio.jpg"));
        geomMercurio.setMaterial(matMercurio);
        
        Material matVenus = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matVenus.setTexture("ColorMap", assetManager.loadTexture("Textures/venus.jpg"));
        geomVenus.setMaterial(matVenus);
        
        Material matTierra = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matTierra.setTexture("ColorMap", assetManager.loadTexture("Textures/tierra.jpg"));
        geomTierra.setMaterial(matTierra);
        
        Material matMarte = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matMarte.setTexture("ColorMap", assetManager.loadTexture("Textures/marte.jpg"));
        geomMarte.setMaterial(matMarte);
        
        Material matJupiter = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matJupiter.setTexture("ColorMap", assetManager.loadTexture("Textures/jupiter.jpg"));
        geomJupiter.setMaterial(matJupiter);
        
        //movemos los Planetas en el eje de las X parapoder visualizarlos y ubicarlos
        geomMercurio.move(10, 0, 0);
        geomVenus.move(20, 0, 0);
        geomTierra.move(30, 0, 0);
        geomMarte.move(40, 0, 0);
        geomJupiter.move(50, 0, 0);
        
        //creamos los nodos para los Planetas
        Node nodoSol = new Node("nodoSol");
        Node nodoMercurio = new Node("nodoMercurio");
        Node nodoVenus = new Node("nodoVenus");
        Node nodoTierra = new Node("nodoTierra");
        Node nodoMarte = new Node("nodoMarte");
        Node nodoJupiter = new Node("nodoJupiter");
        
        //añadimos la geometria de los planetas a los nodos
        nodoSol.attachChild(geomSol);
        nodoMercurio.attachChild(geomMercurio);
        nodoVenus.attachChild(geomVenus);
        nodoTierra.attachChild(geomTierra);
        nodoMarte.attachChild(geomMarte);
        nodoJupiter.attachChild(geomJupiter);
        
        //creamos nodoQueRota que hara rotar los Planetas
        Node nodoQueRotaMercurio = new Node("nodoQueRotaMercurio");
        Node nodoQueRotaVenus = new Node("nodoQueRotaVenus");
        Node nodoQueRotaTierra = new Node("nodoQueRotaTierra");
        Node nodoQueRotaMarte = new Node("nodoQueRotaMarte");
        Node nodoQueRotaJupiter = new Node("nodoQueRotaJupiter");
        
        //añadimos el nodoSol al nodoPadre
        rootNode.attachChild(nodoSol);
        
        //añadimos el nodoQueRotaPlaneta a el nodo sol
        nodoSol.attachChild(nodoQueRotaMercurio);
        nodoSol.attachChild(nodoQueRotaVenus);
        nodoSol.attachChild(nodoQueRotaTierra);
        nodoSol.attachChild(nodoQueRotaMarte);
        nodoSol.attachChild(nodoQueRotaJupiter);
        
        //añadimos los nodos de los planetas a al nodoQueRota
        nodoQueRotaMercurio.attachChild(nodoMercurio);
        nodoQueRotaVenus.attachChild(nodoVenus);
        nodoQueRotaTierra.attachChild(nodoTierra);
        nodoQueRotaMarte.attachChild(nodoMarte);
        nodoQueRotaJupiter.attachChild(nodoJupiter);
        
        //rotamos los nodos de los Planetas para que queden sus
        //polos en norte y sur adecuadamente.
        //como el nodo de los Planetas esta enlazado con el del Sol,
        //solo rotamos el del Sol para que los planetas roten junto con el
        nodoSol.rotate(FastMath.DEG_TO_RAD*90, 0, 0);
        
        
    }

    @Override
    public void simpleUpdate(float tpf) {
        
        //declaramos variables para la velocidad de traslacion y rotacion
        float velocidadOrbitaMercurio = FastMath.DEG_TO_RAD*0.0001f;
        float velocidadRotacionMercurio = FastMath.DEG_TO_RAD*1f;
                
        float velocidadOrbitaVenus = FastMath.DEG_TO_RAD*0.0002f;
        float velocidadRotacionVenus = FastMath.DEG_TO_RAD*1.5f;
         
        float velocidadOrbitaTierra = FastMath.DEG_TO_RAD*0.0003f;
        float velocidadRotacionTierra = FastMath.DEG_TO_RAD*2f;
        
        float velocidadOrbitaMarte = FastMath.DEG_TO_RAD*0.0004f;
        float velocidadRotacionMarte = FastMath.DEG_TO_RAD*2.5f;
        
        float velocidadOrbitaJupiter = FastMath.DEG_TO_RAD*0.0005f;
        float velocidadRotacionJupiter = FastMath.DEG_TO_RAD*3f;
        
        
        
        //orbita y rotacion de Mercurio
        if(orbitaMercurio == null && rotacionMercurio == null)
        {
            orbitaMercurio = rootNode.getChild("nodoQueRotaMercurio");
            rotacionMercurio = rootNode.getChild("nodoMercurio");
        }
        else
        {
            orbitaMercurio.rotate(0, velocidadOrbitaMercurio, 0);
            rotacionMercurio.rotate(0, velocidadRotacionMercurio, 0);
        }
        
        //orbita y rotacion de Venus
        if(orbitaVenus == null && rotacionVenus == null)
        {
            orbitaVenus = rootNode.getChild("nodoQueRotaVenus");
            rotacionVenus = rootNode.getChild("nodoVenus");
        }
        else
        {
            orbitaVenus.rotate(0, velocidadOrbitaVenus, 0);
            rotacionVenus.rotate(0, velocidadRotacionVenus, 0);
        }
        
        //orbita y rotacion de Tierra
        if(orbitaTierra == null && rotacionTierra == null)
        {
            orbitaTierra = rootNode.getChild("nodoQueRotaTierra");
            rotacionTierra = rootNode.getChild("nodoTierra");
        }
        else
        {
            orbitaTierra.rotate(0, velocidadOrbitaTierra, 0);
            rotacionTierra.rotate(0, velocidadRotacionTierra, 0);
        }
        
        //orbita y rotacion de Marte
        if(orbitaMarte == null && rotacionMarte == null)
        {
            orbitaMarte = rootNode.getChild("nodoQueRotaMarte");
            rotacionMarte = rootNode.getChild("nodoMarte");
        }
        else
        {
            orbitaMarte.rotate(0, velocidadOrbitaMarte, 0);
            rotacionMarte.rotate(0, velocidadRotacionMarte, 0);
        }
        
        //orbita y rotacion de Jupiter
        if(orbitaJupiter == null && rotacionJupiter == null)
        {
            orbitaJupiter = rootNode.getChild("nodoQueRotaJupiter");
            rotacionJupiter = rootNode.getChild("nodoJupiter");
        }
        else
        {
            orbitaJupiter.rotate(0, velocidadOrbitaJupiter, 0);
            rotacionJupiter.rotate(0, velocidadRotacionJupiter, 0);
        }
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
