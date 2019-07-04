package mir.routines.umlXpcmRepository_L2R;

import tools.vitruv.extensions.dslsruntime.reactions.AbstractRepairRoutinesFacade;
import tools.vitruv.extensions.dslsruntime.reactions.AbstractRoutinesFacadesProvider;
import tools.vitruv.extensions.dslsruntime.reactions.RoutinesFacadeExecutionState;
import tools.vitruv.extensions.dslsruntime.reactions.structure.ReactionsImportPath;

@SuppressWarnings("all")
public class RoutinesFacadesProvider extends AbstractRoutinesFacadesProvider {
  public AbstractRepairRoutinesFacade createRoutinesFacade(final ReactionsImportPath reactionsImportPath, final RoutinesFacadeExecutionState sharedExecutionState) {
    switch(reactionsImportPath.getPathString()) {
    	case "umlXpcmRepository_L2R": {
    		return new mir.routines.umlXpcmRepository_L2R.RoutinesFacade(this, reactionsImportPath, sharedExecutionState);
    	}
    	case "umlXpcmRepository_L2R.umlXpcmRoutines": {
    		return new mir.routines.umlXpcmRoutines.RoutinesFacade(this, reactionsImportPath, sharedExecutionState);
    	}
    	case "umlXpcmRepository_L2R.umlXpcmRoutines.pcmDataTypePropagationReactions": {
    		return new mir.routines.pcmDataTypePropagationReactions.RoutinesFacade(this, reactionsImportPath, sharedExecutionState);
    	}
    	case "umlXpcmRepository_L2R.umlXpcmRoutines.umlReturnAndRegularParameterTypeReactions": {
    		return new mir.routines.umlReturnAndRegularParameterTypeReactions.RoutinesFacade(this, reactionsImportPath, sharedExecutionState);
    	}
    	default: {
    		throw new IllegalArgumentException("Unexpected import path: " + reactionsImportPath.getPathString());
    	}
    }
  }
}