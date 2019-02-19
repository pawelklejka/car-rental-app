package pl.jkan.carrental;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientData {
    String email;
    String firstName;
    String lastName;
}
