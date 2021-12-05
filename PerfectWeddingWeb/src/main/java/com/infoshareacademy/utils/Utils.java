package com.infoshareacademy.utils;

public class Utils {
    public static String printWelcomeLogo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("  _____  ______ _____  ______ ______ _____ _______  __          ________ _____  _____ _____ _   _  _____  <br></br>");
//        stringBuilder.append("|  __ \\|  ____|  __ \\|  ____|  ____/ ____|__   __| \\ \\        / /  ____|  __ \\|  __ \\_   _| \\ | |/ ____| <br></br>");
//        stringBuilder.append("  _____  ______ _____  ______ ______ _____ _______  __          ________ _____  _____ _____ _   _  _____ <br></br>");
        stringBuilder.append("|  __ \\|  ____|  __ \\|  ____|  ____/ ____|__   __| \\ \\        / /  ____|  __ \\|  __ \\_   _| \\ | |/ ____| <br></br>");
        stringBuilder.append("| |__) | |__  | |__) | |__  | |__ | |       | |     \\ \\  /\\  / /| |__  | |  | | |  | || | |  \\| | |  __ <br></br>");
        stringBuilder.append("|  ___/|  __| |  _  /|  __| |  __|| |       | |      \\ \\/  \\/ / |  __| | |  | | |  | || | | . ` | | |_ |<br></br>");
        stringBuilder.append("| |    | |____| | \\ \\| |    | |___| |____   | |       \\  /\\  /  | |____| |__| | |__| || |_| |\\  | |__| | <br></br>");
        stringBuilder.append("|_|    |______|_|  \\_\\_|    |______\\_____|  |_|        \\/  \\/   |______|_____/|_____/_____|_| \\_|\\_____| <br></br>");

        return stringBuilder.toString();
    }
}
