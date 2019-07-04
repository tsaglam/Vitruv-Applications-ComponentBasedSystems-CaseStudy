package mir.routines.umlXpcmRoutines;

import tools.vitruv.extensions.dslsruntime.reactions.AbstractRepairRoutinesFacade;
import tools.vitruv.extensions.dslsruntime.reactions.AbstractRoutinesFacadesProvider;
import tools.vitruv.extensions.dslsruntime.reactions.RoutinesFacadeExecutionState;
import tools.vitruv.extensions.dslsruntime.reactions.structure.ReactionsImportPath;

@SuppressWarnings("all")
public class RoutinesFacadesProvider extends AbstractRoutinesFacadesProvider {
  public AbstractRepairRoutinesFacade createRoutinesFacade(final ReactionsImportPath reactionsImportPath, final RoutinesFacadeExecutionState sharedExecutionState) {
    switch(reactionsImportPath.getPathString()) {
    	case "umlXpcmRoutines": {
    		return new mir.routines.umlXpcmRoutines.RoutinesFacade(this, reactionsImportPath, sharedExecutionState);
    	}
    	case "umlXpcmRoutines.pcmDataTypePropagationReactions": {
    		return new mir.routines.pcmDataTypePropagationReactions.RoutinesFacade(this, reactionsImportPath, sharedExecutionState);
    	}
    	case "umlXpcmRoutines.umlReturnAndRegularParameterTypeReactions": {
    		return new mir.routines.umlReturnAndRegularParameterTypeReactions.RoutinesFacade(this, reactionsImportPath, sharedExecutionState);
    	}
    	default: {
    		throw new IllegalArgumentException("Unexpected import path: " + reactionsImportPath.getPathString());
    	}
    }
  }
}