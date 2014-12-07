/**
 * @author Matthieu Caron
 * @author Arnaud Cojez
 */

package grammaire;

/**
 * 
 * Classe définissant une variable.
 */
public class Variable {
	
	/* Attributs */
	private String id ;
	
	/* Méthodes */
	
	/**
	 * Constructeur de la classe Variable.
	 * @param id le nom de la variable
	 */
	public Variable(String id){
		this.id=id;
	}
	
	/**
	 * Retourne l'id de la variable.
	 * @return l'id de la Variable
	 */
	public String getID(){
		return this.id ;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Variable other = (Variable) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
}
