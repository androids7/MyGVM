package util.swing.dsl

import javax.swing.*


/**
 * create menu bar
 */


inline fun JFrame.menuBar(init: JMenuBar.() -> Unit) {
    jMenuBar = JMenuBar().apply(init)
}


inline fun JMenuBar.menu(init: JMenu.() -> Unit) {
    add(JMenu().apply(init))
}

inline fun JMenuBar.menu(text: String, mnemonic: Int = 0, init: JMenu.() -> Unit) {
    add(JMenu(text).apply {
        this.mnemonic = mnemonic
        init()
    })
}

inline fun JMenu.item(init: JMenuItem.() -> Unit) {
    add(JMenuItem().apply(init))
}

inline fun JMenu.item(text: String, mnemonic: Int = 0, accelerator: KeyStroke? = null, init: JMenuItem.() -> Unit) {
    add(JMenuItem(text).apply {
        this.mnemonic = mnemonic
        accelerator?.let { this.accelerator = it }
        init()
    })
}

inline fun JMenu.separator() {
    add(JSeparator())
}
