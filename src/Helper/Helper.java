package Helper;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Helper {
	
	public static void  optionPaneChangeButtonText() {
		UIManager.put("OptionPane.cancelButtonText", "�ptal");
		UIManager.put("OptionPane.noButtonText", "Hay�r");
		UIManager.put("OptionPane.okButtonText", "Tamam");
		UIManager.put("OptionPane.yesButtonText", "Evet");
	}

	public static void showMessage(String str) {
		optionPaneChangeButtonText();
		String msg;
		switch (str) {
		case "fill":
			msg = "L�tfen t�m alanlar� doldurunuz.";
			break;
		case "success":
			msg = "��lem Ba�ar�l� !";
			break;
		case "error":
			msg="Bir hata ger�ekle�ti";
			break;
		default:
			msg = str;

		}
		JOptionPane.showMessageDialog(null, msg, "Mesaj", JOptionPane.INFORMATION_MESSAGE);
	}

	public static boolean confirm(String str) {
		optionPaneChangeButtonText();
		String msg;
		switch (str) {
		case "sure":
			msg = "Bu i�lemi ger�ekle�tirmek istiyor musun?";
			break;
		default:
			msg = str;
			break;
		}
		int res = JOptionPane.showConfirmDialog(null, msg, "Dikkat !", JOptionPane.YES_NO_OPTION);
		if (res == 0) {
			return true;
		} else {
			return false;
		}
	}
}