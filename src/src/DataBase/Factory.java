package DataBase;

public class Factory {

    private static final String local = "containers-us-west-181.railway.app";
    private static final String porta = "7682";
    private static final String bd = "railway";
    private static final String user = "root";
    private static final String senha = "RzbUN31XmK9QvBX2JbWC";

    public static Conexao creatConnectionToMySQL(){
        return new Conexao(getLocal(),getPorta(),getBd(),getUser(),getSenha());
    }


	public static String getLocal() {
		return local;
	}
	public static String getPorta() {
		return porta;
	}
	public static String getBd() {
		return bd;
	}
	public static String getUser() {
		return user;
	}
	public static String getSenha() {
		return senha;
	}

	

}

