/*******************************************************************************
 * Copyright (c) 2000, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Abel Gómez - refactoring to a new class 
 *******************************************************************************/

package es.unizar.disco.core.ui.util;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * This class allows to draw an arrow between two {@link Control}s contained in
 * the same {@link Composite} that appears when hovering with the mouse. This
 * class contains code extracted from
 * {@link org.eclipse.jdt.internal.ui.preferences.OptionsConfigurationBlock}.
 * 
 * @author agomez
 *
 */
public class Highlighter {
	
	protected static final int HIGHLIGHT_FOCUS = SWT.COLOR_WIDGET_DARK_SHADOW;
	protected static final int HIGHLIGHT_MOUSE = SWT.COLOR_WIDGET_NORMAL_SHADOW;
	protected static final int HIGHLIGHT_NONE = SWT.NONE;
	
	private static class HighlightPainter implements PaintListener {
		
		private final Composite fParent;
		private final Control fLabelControl;
		private final Control fComboBox;
		int fColor;
		
		public HighlightPainter(Composite parent, Control leftControl, Control rightControl, int color) {
			fParent= parent;
			fLabelControl= leftControl;
			fComboBox= rightControl;
			fColor= color;
		}

		public void paintControl(PaintEvent e) {
			if (((GridData) fLabelControl.getLayoutData()).exclude) {
				fParent.removePaintListener(this);
				fLabelControl.setData(null);
				return;
			}
			
			int GAP= 7;
			int ARROW= 3;
			Rectangle l= fLabelControl.getBounds();
			Point c= fComboBox.getLocation();
			
			e.gc.setForeground(e.display.getSystemColor(fColor));
			int x2= c.x - GAP;
			int y= l.y + l.height / 2 + 1;
			
			e.gc.drawLine(l.x + l.width + GAP, y, x2, y);
			e.gc.drawLine(x2 - ARROW, y - ARROW, x2, y);
			e.gc.drawLine(x2 - ARROW, y + ARROW, x2, y);
		}
	}
	
	public static void addHighlight(final Composite parent, final Control leftControl, final Control rightControl) {
		rightControl.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				highlight(parent, leftControl, rightControl, HIGHLIGHT_NONE);
			}
			public void focusGained(FocusEvent e) {
				highlight(parent, leftControl, rightControl, HIGHLIGHT_FOCUS);
			}
		});
		
		MouseTrackAdapter labelComboListener= new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				highlight(parent, leftControl, rightControl, rightControl.isEnabled() ? rightControl.isFocusControl() ? HIGHLIGHT_FOCUS : HIGHLIGHT_MOUSE : HIGHLIGHT_NONE);
			}
			@Override
			public void mouseExit(MouseEvent e) {
				if (! rightControl.isFocusControl())
					highlight(parent, leftControl, rightControl, HIGHLIGHT_NONE);
			}
		};
		rightControl.addMouseTrackListener(labelComboListener);
		leftControl.addMouseTrackListener(labelComboListener);
		
		class MouseMoveTrackListener extends MouseTrackAdapter implements MouseMoveListener, MouseListener {
			@Override
			public void mouseExit(MouseEvent e) {
				if (! rightControl.isFocusControl())
					highlight(parent, leftControl, rightControl, HIGHLIGHT_NONE);
			}
			public void mouseMove(MouseEvent e) {
				int color= rightControl.isEnabled() ? rightControl.isFocusControl() ? HIGHLIGHT_FOCUS : isAroundLabel(e) ? HIGHLIGHT_MOUSE : HIGHLIGHT_NONE : HIGHLIGHT_NONE;
				highlight(parent, leftControl, rightControl, color);
			}
			public void mouseDown(MouseEvent e) {
				if (isAroundLabel(e))
					rightControl.setFocus();
			}
			public void mouseDoubleClick(MouseEvent e) {
				// not used
			}
			public void mouseUp(MouseEvent e) {
				// not used
			}
			private boolean isAroundLabel(MouseEvent e) {
				int lx= leftControl.getLocation().x;
				Rectangle c= rightControl.getBounds();
				int x= e.x;
				int y= e.y;
				boolean isAroundLabel= lx - 5 < x && x < c.x && c.y - 2 < y && y < c.y + c.height + 2;
				return isAroundLabel;
			}
		}
		MouseMoveTrackListener parentListener= new MouseMoveTrackListener();
		parent.addMouseMoveListener(parentListener);
		parent.addMouseTrackListener(parentListener);
		parent.addMouseListener(parentListener);
		
		MouseAdapter labelClickListener= new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				rightControl.setFocus();
			}
		};
		leftControl.addMouseListener(labelClickListener);
	}
	
	
	private static void highlight(final Composite parent, final Control leftControl, final Control rightControl, final int color) {
		Object data= leftControl.getData();
		if (data == null) {
			if (color != HIGHLIGHT_NONE) {
				PaintListener painter= new HighlightPainter(parent, leftControl, rightControl, color);
				parent.addPaintListener(painter);
				leftControl.setData(painter);
			} else {
				return;
			}
		} else {
			if (color == HIGHLIGHT_NONE) {
				parent.removePaintListener((PaintListener) data);
				leftControl.setData(null);
			} else if (color != ((HighlightPainter) data).fColor){
				((HighlightPainter) data).fColor= color;
			} else {
				return;
			}
		}
		
		parent.redraw();
	}
}
