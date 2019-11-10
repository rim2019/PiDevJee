using entities.Entities;
using Service;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Net;
using System.Collections.Specialized;
using System.Net.Mail;
using System.Web.Services.Description;

namespace WebApp.Controllers
{
    public class ClientController : Controller
    {
        // GET: Client
        public ActionResult Index()
        {
            ClientService cs = new ClientService();
          
            return View(cs.GetAll());
        }
        public ActionResult IndexFront()
        {
            return View();
        }

        // GET: Client/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }

        // GET: Client/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Client/Create
        [HttpPost]
        public ActionResult Create(Client c)
        {
            try
            {
                ClientService cs = new ClientService();
                Random random = new Random();
                c.PasswordClient = random.Next().ToString();
                c.RoleClient = "client";
                c.Points = 100;
                var senderEmail = new MailAddress("khalil.bali@esprit.tn", "khalil");
                var receiverEmail = new MailAddress(c.EmailClient,c.NomClient);

                var smtp = new SmtpClient
                {
                    Host = "smtp.gmail.com",
                    Port = 587,
                    EnableSsl = true,
                    DeliveryMethod = SmtpDeliveryMethod.Network,
                    UseDefaultCredentials = false,
                    Credentials = new NetworkCredential(senderEmail.Address, "bali301995")
                };
                using (var mess = new MailMessage(senderEmail, receiverEmail)
                {
                    Subject = "Inscription MyApp",
                    Body = "Bienvenue , voici votre mot de passe pour acceder a votre espace"+ c.PasswordClient 
                })
                {
                    smtp.Send(mess);
                }

                cs.Add(c);
                cs.Commit();
               
                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Client/Edit/5
        public ActionResult Edit(int id)
        {
           ClientService cs = new ClientService();
            return View(cs.GetById(id));
        }

        // POST: Client/Edit/5
        [HttpPost]
        public ActionResult Edit(int id,Client c)
        {
            try
            {
                ClientService cs = new ClientService();
                Client cc= cs.GetById(id);
                cc.ClientId = c.ClientId;
                cc.NomClient = c.NomClient;
                cc.RoleClient = c.RoleClient;
                cc.AdresseClient = c.AdresseClient;
                cc.EmailClient = c.EmailClient;
                cc.PasswordClient = c.PasswordClient;
                cc.NumeroClient = c.NumeroClient;
                cc.Points = c.Points;
                cc.TypeClient = c.TypeClient;
                cc.AgeClient = c.AgeClient;
                 cs.Update(cc);
                 cs.Commit();

                // TODO: Add update logic here

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Client/Delete/5
        public ActionResult Delete(int id)
        {
            ClientService cs = new ClientService();
           
            return View(cs.GetById(id));
        }

        // POST: Client/Delete/5
        [HttpPost]
        public ActionResult Delete(int id,Client c)
        {
            try
            {
                ClientService cs = new ClientService();
               c = cs.GetById(id);
                cs.Delete(c);
                cs.Commit();
                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }
        public ActionResult login()
        {
            ClientService cs = new ClientService();

            return View();
        }

        [HttpPost]
        public ActionResult login(Client c)
        {
           

                ClientService cs = new ClientService();
              var x= cs.GetAll().Where(a => a.NumeroClient == c.NumeroClient && a.PasswordClient==c.PasswordClient).FirstOrDefault();
                if (x==null )
                {
                    
                    return View("Login",c);

                }
                else
                {
                    Session["ClientId"] = x.ClientId;
                    Session["Clientname"] = x.NomClient;
                if (x.RoleClient=="admin")
                {
                    return RedirectToAction("Index");
                }
                else
                {
                    return RedirectToAction("IndexFront");
                }
                     
                  
                    
                   
                }

          }
        public ActionResult logout()
        {
            Session.Abandon();

            return RedirectToAction("login");
        }

        public ActionResult Changepassword(int id)
        {
            id = (int)Session["ClientId"];
            ClientService cs = new ClientService();
            return View(cs.GetById(id));
        }

        [HttpPost]
        public ActionResult Changepassword(int id,Client c)
        {
            id = (int)Session["ClientId"];
            ClientService cs = new ClientService();
            Client cc = cs.GetById(id);
            cc.ClientId = c.ClientId;
            cc.PasswordClient = c.PasswordClient;
           cs.Update(cc);
            cs.Commit();
            return RedirectToAction("login");
        }

       public ActionResult TransfertPoints(int id)
        {
            id = (int)Session["ClientId"];
            ClientService cs = new ClientService();
            return View(cs.GetById(id));
        }

        [HttpPost]
        public ActionResult TransfertPoints(int id, Client connected,int points,int numero)
        {
            id = (int)Session["ClientId"];
            ClientService cs = new ClientService();
            var x= cs.GetAll().Where(a => a.NumeroClient == numero).FirstOrDefault();
            Client cc = cs.GetById(id);
            Client cc2 = cs.GetById(x.ClientId);
            cc.ClientId = connected.ClientId;
           
           
                cc2.Points = cc2.Points + points;
                cs.Update(cc2);
                cs.Commit();
                cc.Points = cc.Points - points;
                cs.Update(cc);
                cs.Commit();
            
            return RedirectToAction("IndexFront");
        }

        public ActionResult dashboard()
        {
            ClientService cs = new ClientService();
            var list = cs.GetAll();
            List<int> repartitions = new List<int>();
            var ages = list.Select(x => x.AgeClient).Distinct();
            foreach(var item in ages)
            {
                repartitions.Add(list.Count(x => x.AgeClient == item));
            }
            var rep = repartitions;
            ViewBag.AGES = ages;
            ViewBag.REP = repartitions.ToList();
            return View();
        }

    }
}
