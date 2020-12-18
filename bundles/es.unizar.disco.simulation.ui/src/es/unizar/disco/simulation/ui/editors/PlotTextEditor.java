/*******************************************************************************
 * Copyright (c) 2020 DisCo Group - Universidad de Zaragoza.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-1.0/
 *
 * SPDX-License-Identifier: EPL-1.0
 *
 * Contributors:
 *     Abel Gómez
 *     Ignacio Requeno
 *     Diego Pérez
 *******************************************************************************/
package es.unizar.disco.simulation.ui.editors;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.editors.text.TextEditor;

public class PlotTextEditor extends TextEditor {
	
	public PlotTextEditor() {
		super();
		setSourceViewerConfiguration(new PlotSourceViewerConfiguration());
	}

	private class StartOfLineRule extends EndOfLineRule {
		public StartOfLineRule(String startSequence, IToken token) {
			super(startSequence, token);
		}
		@Override
		public IToken evaluate(ICharacterScanner scanner, boolean resume) {
			if (scanner.getColumn() == 0) {
				while (Character.isWhitespace(scanner.read()));
				scanner.unread();
				return super.evaluate(scanner, resume);
			}
			return Token.UNDEFINED;
		}
	}
	
	private class PlotRuleScanner extends RuleBasedScanner {
		public PlotRuleScanner() {
			IToken commentToken = new Token(new TextAttribute(Display.getDefault().getSystemColor(SWT.COLOR_DARK_GREEN)));
			setRules(new IRule[] { new StartOfLineRule("#", commentToken) });
		}
	}

	private class PlotSourceViewerConfiguration extends SourceViewerConfiguration {
		private PlotRuleScanner scanner = new PlotRuleScanner();

		@Override
		public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
			PresentationReconciler reconciler = new PresentationReconciler();
			reconciler.setDocumentPartitioning(getConfiguredDocumentPartitioning(sourceViewer));
			DefaultDamagerRepairer damagerRepairer = new DefaultDamagerRepairer(scanner);
			reconciler.setDamager(damagerRepairer, IDocument.DEFAULT_CONTENT_TYPE);
			reconciler.setRepairer(damagerRepairer, IDocument.DEFAULT_CONTENT_TYPE);
			return reconciler;
		}
	}
}