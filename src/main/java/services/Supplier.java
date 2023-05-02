package services;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.logging.Logger;

@Path("/supplier")
public class Supplier {

    private static final Logger LOGGER = Logger.getLogger(Supplier.class);

    @POST
    @Path("{supplier-id}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String sendOrder(@PathParam("supplier-id") String supplierId, String orderNumber) {
        LOGGER.info(String.format("Supplier %s received the order %s%n", supplierId, orderNumber));
        return "receipt-" + supplierId + "-" + orderNumber;
    }

    @DELETE
    @Path("{supplier-id}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String cancelOrder(@PathParam("supplier-id") String supplierId, String orderNumber) {
        LOGGER.info(String.format("Supplier %s acknowledges the order cancellation %s%n", supplierId, orderNumber));
        return "cancel-ack-" + supplierId + "-" + orderNumber;
    }
}