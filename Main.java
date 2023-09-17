import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.net.URI;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input pokemon name:");
        String pokemon = sc.nextLine();
        System.out.println("Searching pokemon...");

        getPokemon(pokemon);

        sc.close();
    }

    public static void getPokemon(String pokemon) {
        StringBuilder baseUrl = new StringBuilder("https://pokeapi.co/api/v2/pokemon/");
        String url = baseUrl.append(pokemon).toString();
        HttpURLConnection request = null;
        InputStream stream = null;
        BufferedReader reader = null;

        try {
            URL api = new URI(url).toURL();

            request = (HttpURLConnection) api.openConnection();
            stream = request.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));

            String stringResponse;

            while ((stringResponse = reader.readLine()) != null) {
                System.out.println(stringResponse);
            }

            reader.close();
        } catch (Exception e) {
            System.out.println("Pokemon not found");
        }
    }
}
