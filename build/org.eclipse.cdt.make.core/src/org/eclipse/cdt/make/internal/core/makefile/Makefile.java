/**********************************************************************
 * Copyright (c) 2002,2003 QNX Software Systems and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 *
 * Contributors:
 * QNX Software Systems - Initial API and implementation
***********************************************************************/
package org.eclipse.cdt.make.internal.core.makefile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * Makefile : ( statement ) *
 * statement :   rule | macro_definition | comments | empty
 * rule :  inference_rule | target_rule
 * inference_rule : target ':' <nl> ( <tab> command <nl> ) +
 * target_rule : target [ ( target ) * ] ':' [ ( prerequisite ) * ] [ ';' command ] <nl> 
                 [ ( command ) * ]
 * macro_definition : string '=' (string)* 
 * comments : ('#' (string) <nl>) *
 * empty : <nl>
 * command : <tab> prefix_command string <nl>
 * target : string
 * prefix_command : '-' | '@' | '+'
 * internal_macro :  "$<" | "$*" | "$@" | "$?" | "$%" 
 */

public abstract class Makefile {

	String filename;

	public Makefile(String name) throws FileNotFoundException, IOException {
		filename = name;
	}

	public abstract List getStatements();

	public abstract List getBuiltins();

	public String getFileName() {
		return filename;
	}

	public Rule[] getRules() {
		return null;
	}
	public Rule getRule(String target) {
		return null;
	}
	public InferenceRule[] getInferenceRules() {
		return null;
	}
	public InferenceRule getInferenceRule(String target) {
		return null;
	}
	public TargetRule[] getTargetRules() {
		return null;
	}
	public TargetRule getTargetRule(String target) {
		return null;
	}

	public Rule[] getBuiltinRules() {
		return null;
	}
	public Rule getBuiltinRule(String target) {
		return null;
	}
	public Rule[] getBuiltinInferenceRules() {
		return null;
	}
	public Rule getBuiltinInferenceRule(String target) {
		return null;
	}

	public MacroDefinition[] getMacros() {
		return null;
	}
	public MacroDefinition getMacro(String name) {
		return null;
	}
	public MacroDefinition[] getBuiltinMacros() {
		return null;
	}
	public MacroDefinition getBuiltinMacro(String name) {
		return null;
	}
}
