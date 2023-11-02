package Entities;

public class Etudiant {

	public String code;
	public String nom;
	public	 int age;
	public String ville;
	public String prenom;
	public Etudiant(String code, String nom, String prenom, int age, String ville) {
		super();
		this.code = code;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.ville = ville;
	}
	public Etudiant() {
		super();
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	@Override
	public String toString() {
		return "Etudiant [code=" + code + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", ville=" + ville
				+ "]";
	}
	
}
