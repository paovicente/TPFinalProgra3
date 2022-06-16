package prueba;

import java.util.ArrayList;
import java.util.Scanner;

import paquete.AdminAgencia;
import paquete.Empleado;
import paquete.Empleador;
import paquete.FormularioDeBusqueda;
import paquete.Sistema;
import paquete.TicketBuscaEmpleado;
import paquete.TicketBuscaEmpleo;
import paquete.Usuario;
import paquete.UsuarioInteractivo;
import subclasesDeAtributosDeFormulario.CargaCompleta;
import subclasesDeAtributosDeFormulario.CargaExtendida;
import subclasesDeAtributosDeFormulario.CargaMedia;
import subclasesDeAtributosDeFormulario.Entre40y50;
import subclasesDeAtributosDeFormulario.HomeOffice;
import subclasesDeAtributosDeFormulario.Indistinto;
import subclasesDeAtributosDeFormulario.Junior;
import subclasesDeAtributosDeFormulario.Management;
import subclasesDeAtributosDeFormulario.MasDe50;
import subclasesDeAtributosDeFormulario.Media;
import subclasesDeAtributosDeFormulario.MenosDe40;
import subclasesDeAtributosDeFormulario.Mucha;
import subclasesDeAtributosDeFormulario.Nada;
import subclasesDeAtributosDeFormulario.Presencial;
import subclasesDeAtributosDeFormulario.Primario;
import subclasesDeAtributosDeFormulario.Secundario;
import subclasesDeAtributosDeFormulario.Senior;
import subclasesDeAtributosDeFormulario.Terciario;
import subclasesDeAtributosDeFormulario.V1;
import subclasesDeAtributosDeFormulario.V2;
import subclasesDeAtributosDeFormulario.V3;


public class Prueba {
	public static void main(String[] args) {
		Sistema sistema = Sistema.getInstancia();
		
		
			System.out.println("Bienvenido al mejor sistema de contrataciones. ¿Qué desea hacer?");
			System.out.println("1-Registarse manualmente");
			System.out.println("2-Forzar registros");
			Scanner scanner = new Scanner(System.in);
			int i= scanner.nextInt();
			
			if (i==1) {
				int x;
				do {                       //registro
					sistema.registrarse();
					System.out.println("Ingrese 0 para dejar de registrar. Ingrese cualquier otro dígito para seguir registrando usuarios.");
	                x= scanner.nextInt();
				} while (x!=0);	     //fin registro
				
				
				System.out.println("Ingresa nombre de usuario");
				String basura= scanner.nextLine();          //para leer 2 strings 
				String nomUsuario = scanner.nextLine();
				System.out.println("Ingresa tu contraseña");
				String contra = scanner.nextLine();
				Usuario usuario = sistema.login(nomUsuario, contra);      //login
					
				Usuario admin = new AdminAgencia("asdb","sdgf","dfg");
				sistema.rondaDeEncuentrosLaborales((AdminAgencia) admin,(UsuarioInteractivo) usuario);       //ronda encuentros y elecciones
				
				sistema.rondaContrataciones();        //ronda contrataciones
				
			} else if (i==2) {
				FormularioDeBusqueda form= new FormularioDeBusqueda();
				form.setCargahoraria(new CargaMedia());
				form.setEstudiosCursados(new Primario());
				form.setExperiencia(new Nada());
				form.setLocacion(new HomeOffice());
				form.setRangoEtario(new MenosDe40());
				form.setRemuneracion(new V1());
				form.setTipoPuesto(new Junior());
				
				Usuario usuario1 = new Empleado("messi","elpepe","abc123",0,"ronaldinho","22341235",41);
				Empleado empleado1= (Empleado) usuario1;
				empleado1.setTicket(new TicketBuscaEmpleo(form));
				sistema.addEmpleado(empleado1); 
				
				
				
				FormularioDeBusqueda form5= new FormularioDeBusqueda();
				form5.setCargahoraria(new CargaExtendida());
				form5.setEstudiosCursados(new Terciario());
				form5.setExperiencia(new Mucha());
				form5.setLocacion(new Presencial());
				form5.setRangoEtario(new MasDe50());
				form5.setRemuneracion(new V3());
				form5.setTipoPuesto(new Management());
				
				Usuario usuario5 = new Empleado("juan","qqq","www",0,"apellido","2234122131235",41);
				Empleado empleado2= (Empleado) usuario5;
				empleado2.setTicket(new TicketBuscaEmpleo(form5));
				sistema.addEmpleado(empleado2);
				
				FormularioDeBusqueda form1= new FormularioDeBusqueda();
				form1.setCargahoraria(new CargaExtendida());
				form1.setEstudiosCursados(new Terciario());
				form1.setExperiencia(new Mucha());
				form1.setLocacion(new Presencial());
				form1.setRangoEtario(new MasDe50());
				form1.setRemuneracion(new V3());
				form1.setTipoPuesto(new Management());
				
				FormularioDeBusqueda form2= new FormularioDeBusqueda();
				form2.setCargahoraria(new CargaMedia());
				form2.setEstudiosCursados(new Primario());
				form2.setExperiencia(new Nada());
				form2.setLocacion(new HomeOffice());
				form2.setRangoEtario(new MenosDe40());
				form2.setRemuneracion(new V1());
				form2.setTipoPuesto(new Junior());
				
				ArrayList<Double> pesos = new ArrayList<Double>();
				pesos.add((double) 5);
				pesos.add((double) 5);
				pesos.add((double) 5);
				pesos.add((double) 5);
				pesos.add((double) 5);
				pesos.add((double) 5);
				pesos.add((double) 5);
				Usuario usuario2 = new Empleador("fravega","macri","def456",0,true,"Salud");
				
				Empleador empleador1 = (Empleador) usuario2;
				empleador1.addTicket(new TicketBuscaEmpleado(form1,2,pesos));
				empleador1.addTicket(new TicketBuscaEmpleado(form2,2,pesos));
				sistema.addEmpleador(empleador1);
				
				FormularioDeBusqueda form3= new FormularioDeBusqueda();
				form3.setCargahoraria(new CargaMedia());
				form3.setEstudiosCursados(new Primario());
				form3.setExperiencia(new Nada());
				form3.setLocacion(new HomeOffice());
				form3.setRangoEtario(new MenosDe40());
				form3.setRemuneracion(new V1());
				form3.setTipoPuesto(new Junior());
				Usuario usuario3 = new Empleador("mcdonalds","messi","xyz123",0,true,"Salud");
				
				Empleador empleador2= (Empleador) usuario3;
		
				ArrayList<Double> pesos1 = new ArrayList<Double>();
				pesos1.add((double) 10);
				pesos1.add((double) 10);
				pesos1.add((double) 10);
				pesos1.add((double) 10);
				pesos1.add((double) 10);
				pesos1.add((double) 10);
				pesos1.add((double) 10);
				pesos1.add((double) 10);
				
				empleador2.addTicket(new TicketBuscaEmpleado(form3,2,pesos1));
				sistema.addEmpleador(empleador2);
				
				Usuario usuario4= new Empleador("MercadoLibre","aaa","bbb",1,false,"Salud");
				FormularioDeBusqueda form4= new FormularioDeBusqueda();
				form4.setCargahoraria(new CargaCompleta());
				form4.setEstudiosCursados(new Secundario());
				form4.setExperiencia(new Media());
				form4.setLocacion(new Indistinto());
				form4.setRangoEtario(new Entre40y50());
				form4.setRemuneracion(new V2());
				form4.setTipoPuesto(new Senior());
				
				Empleador empleador3= (Empleador) usuario4;
				ArrayList<Double> pesos2 = new ArrayList<Double>();
				pesos2.add((double) 15);
				pesos2.add((double) 15);
				pesos2.add((double) 15);
				pesos2.add((double) 15);
				pesos2.add((double) 15);
				pesos2.add((double) 15);
				pesos2.add((double) 15);
				pesos2.add((double) 15);
				empleador3.addTicket(new TicketBuscaEmpleado(form4,2,pesos2));
				sistema.addEmpleador(empleador3);
				
				usuario1 = sistema.login("elpepe", "abc123");
				usuario2 = sistema.login("macri", "def456");
				usuario3 = sistema.login("messi", "xyz123");
				usuario4 = sistema.login("aaa", "bbb"); 
				usuario5= sistema.login("qqq", "www"); 
				
				
				Usuario admin = new AdminAgencia("asdb","sdgf","dfg");
				sistema.rondaDeEncuentrosLaborales((AdminAgencia) admin,(UsuarioInteractivo) empleado2);       //ronda encuentros y elecciones
				sistema.rondaDeEncuentrosLaborales((AdminAgencia) admin,(UsuarioInteractivo) empleador3);
				
				
				
				sistema.rondaContrataciones();        //ronda contrataciones
		
				sistema.actualizaPuntajes();
				
				empleado2.getTicket().getFormulario();
				
				System.out.println("fecha de la lista del ticket del empleado 2: " + empleado2.getTicket().getLista().getFecha());
				
				/*sistema.calcularComision(empleado2,empleado2.getTicket().getFormulario());
				sistema.calcularComision(empleador3, form4);*/
			} else
				System.out.println("Eleccion incorrecta.");
	
	}

}
