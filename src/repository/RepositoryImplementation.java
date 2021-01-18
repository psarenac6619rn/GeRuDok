
package repository;

import core.Repository;

import java.io.Serializable;

public class RepositoryImplementation implements Repository, Serializable {

	private Workspace rootWorkspace;
	
	
	
	public Workspace getRootWorkspace() {
		return rootWorkspace;
	}



	public void setRootWorkspace(Workspace rootWorkspace) {
		this.rootWorkspace = rootWorkspace;
	}



	public RepositoryImplementation() {
		rootWorkspace = new Workspace("Workspace");
	}



	@Override
	public Workspace getWorkspace() {
		return rootWorkspace;
	}

}
